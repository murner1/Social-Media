package com.cooksys.SocialMedia.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Dtos.CredentialsDto;
import com.cooksys.SocialMedia.Dtos.TweetRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Embeddable.Credentials;
import com.cooksys.SocialMedia.Entities.Hashtag;
import com.cooksys.SocialMedia.Entities.Tweet;
import com.cooksys.SocialMedia.Entities.User;
import com.cooksys.SocialMedia.Exceptions.BadRequestException;
import com.cooksys.SocialMedia.Exceptions.NotFoundException;
import com.cooksys.SocialMedia.Mappers.TweetMapper;
import com.cooksys.SocialMedia.Mappers.UserMapper;
import com.cooksys.SocialMedia.Repositories.HashtagRepository;
import com.cooksys.SocialMedia.Repositories.TweetRepository;
import com.cooksys.SocialMedia.Repositories.UserRepository;
import com.cooksys.SocialMedia.Services.TweetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TweetServiceImpl implements TweetService {
	private TweetRepository tweetRepository;

	private TweetMapper tweetMapper;

	private UserMapper userMapper;

	private UserRepository userRepository;

	private HashtagRepository hashtagRepository;

	private Tweet returnTweetFromId(Long id) {
		Optional<Tweet> tweet = tweetRepository.findById(id);
		if (tweet.isPresent()) {
			return tweet.get();
		} else {
			throw new NotFoundException("This tweet does not exist");
		}

	}

	private User validateCredentials(CredentialsDto credentialsDto) {
		if(credentialsDto.getPassword()== null || credentialsDto.getPassword()==null) {
			throw new BadRequestException("Username and Password must be provided");
		}
		
		Optional<User> user =userRepository.findByCredentialsUsername(credentialsDto.getUsername());
		if(user.isEmpty()|| user.get().isDeleted()) {
			throw new NotFoundException("Cannot alter tweets because user cannot be found.");
		}
		if(!credentialsDto.getPassword().equals(user.get().getCredentials().getPassword())) {
			throw new NotFoundException("Cannot alter tweets. Password is invalid");
		}
		return user.get();
	}

	@Override
	public TweetResponseDto postTweet(TweetRequestDto tweetRequestDto) {
		// need to check that the credentials match an active user, if not send an error
		// For now we don't need to check that it does not have inReplyTo or repostOf
		// because tweetRequestDto only has content and credentials

		// Check that the tweet has content
		if (tweetRequestDto.getContent() == null) {
			throw new BadRequestException("Content is required for posting a tweet");
		}

		// get the author of the tweet from the credentials
		User tweetAuthor = validateCredentials(tweetRequestDto.getCredentials());

		Tweet tweetToSave = tweetMapper.requestDtoToEntity(tweetRequestDto);

		tweetToSave.setAuthor(tweetAuthor);

		// need to scan through the tweeet for @{username} and #{hastag} and add these
		// this could give issues if someone dosn't put a space before their hashtag or
		// mention
		String[] contentAsArray = tweetToSave.getContent().split(" ", 0);

		// could be nice to make these thier own methods
		for (int i = 0; i < contentAsArray.length; i++) {
			if (contentAsArray[i].contains("#")) {
				//does this cause problems if the hashtag already exists?
				Hashtag hashtag = new Hashtag();
				hashtag.setLabel(contentAsArray[i]);
				hashtag.getTweets().add(tweetToSave);
				tweetToSave.getHashtags().add(hashtag);
				hashtagRepository.saveAndFlush(hashtag);
			}

			if (contentAsArray[i].contains("@")) {
				Optional<User> userMentioned = userRepository.findByCredentialsUsername(contentAsArray[i].substring(1));
				if (userMentioned.isPresent()) {
					tweetToSave.getUsersMentioned().add(userMentioned.get());
					
				}
			}

			List<User> usersMentioned = tweetToSave.getUsersMentioned();
			for (int j = 0; j < usersMentioned.size(); j++) {
				usersMentioned.get(j).getMentions().add(0, tweetToSave);
				userRepository.saveAndFlush(usersMentioned.get(j));
			}

		}

		// Save the tweet and and return it
		return tweetMapper.entityToResponseDto(tweetRepository.saveAndFlush(tweetToSave));
	}
	
	@Override
	public TweetResponseDto repostTweet(CredentialsDto credentialsDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserResponseDto> getMentions(Long id) {
		Optional<Tweet> tweet = tweetRepository.findById(id);
		if (tweet.isPresent()) {
			List<User> mentioned = tweet.get().getUsersMentioned();
			for (User user : mentioned) {
				if (user.isDeleted()) {
					mentioned.remove(user);
				}
			}
			return userMapper.entititesToDto(mentioned);
		} else {
			throw new NotFoundException("This tweet does not exist");
		}
	}

	@Override
	public List<TweetResponseDto> getReposts(Long id) {
		Optional<Tweet> tweet = tweetRepository.findById(id);
		if (tweet.isPresent()) {
			List<Tweet> reposts = tweet.get().getReposts();
			for (Tweet repost : reposts) {
				if (repost.isDeleted()) {
					reposts.remove(repost);
				}
			}
			return tweetMapper.entitiesToDto(reposts);
		} else {
			throw new NotFoundException("This tweet does not exist");
		}
	}

	@Override
	public List<TweetResponseDto> getReplies(Long id) {
		Optional<Tweet> tweet = tweetRepository.findById(id);
		if (tweet.isPresent()) {
			List<Tweet> replies = tweet.get().getReplies();
			for (Tweet reply : replies) {
				if (reply.isDeleted()) {
					replies.remove(reply);
				}
			}
			return tweetMapper.entitiesToDto(replies);
		} else {
			throw new NotFoundException("This tweet does not exist");
		}
	}

	@Override
	public List<UserResponseDto> getLikes(Long id) {
		Optional<Tweet> tweet = tweetRepository.findById(id);
		if (tweet.isPresent()) {
			List<User> likes = tweet.get().getUserLikes();
			for (User like : likes) {
				if (like.isDeleted()) {
					likes.remove(like);
				}
			}
			return userMapper.entititesToDto(likes);
		} else {
			throw new NotFoundException("This tweet does not exist");
		}
	}

	@Override
	public TweetResponseDto getTweetById(Long id) {
		Optional<Tweet> tweet = tweetRepository.findById(id);
		if (tweet.isPresent()) {
			return tweetMapper.entityToResponseDto(tweet.get());
		} else {
			throw new NotFoundException("This tweet does not exist");
		}
	}

	@Override
	public List<TweetResponseDto> getAllTweets() {
		return tweetMapper.entitiesToDto(tweetRepository.findAllByDeleted(false));

	}

	@Override
	public TweetResponseDto deleteTweet(CredentialsDto credentialsDto, Long id) {
		User user =validateCredentials(credentialsDto);
		Tweet tweetToDelete = returnTweetFromId(id);
		if (!tweetToDelete.getAuthor().equals(user)) {
			throw new BadRequestException("Credentials do not match tweet Author");
		}
		tweetToDelete.setDeleted(true);
		return tweetMapper.entityToResponseDto(tweetRepository.saveAndFlush(tweetToDelete));
		
		
	}


}
