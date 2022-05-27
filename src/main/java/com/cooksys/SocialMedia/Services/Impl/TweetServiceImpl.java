package com.cooksys.SocialMedia.Services.Impl;

import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.Tweet;
import com.cooksys.SocialMedia.Entities.User;
import com.cooksys.SocialMedia.Exceptions.NotFoundException;
import com.cooksys.SocialMedia.Mappers.TweetMapper;
import com.cooksys.SocialMedia.Mappers.UserMapper;
import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Repositories.TweetRepository;
import com.cooksys.SocialMedia.Services.TweetService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TweetServiceImpl implements TweetService{
	private TweetRepository tweetRepository;

	private TweetMapper tweetMapper;

	private UserMapper userMapper;

	@Override
	public List<UserResponseDto> getMentions(Long id) {
		Optional<Tweet> tweet = tweetRepository.findById(id);
		if(tweet.isPresent()) {
			List<User> mentioned = tweet.get().getUsersMentioned();
			for (User user : mentioned) {
				if(user.getDeleted()){
					mentioned.remove(user);
				}
			}
			return userMapper.entititesToDto(mentioned);
		}
		else{
			throw new NotFoundException("This tweet does not exist");
		}
	}

	@Override
	public List<TweetResponseDto> getReposts(Long id) {
		Optional<Tweet> tweet = tweetRepository.findById(id);
		if(tweet.isPresent()){
			List<Tweet> reposts = tweet.get().getReposts();
				for(Tweet repost : reposts){
					if(repost.isDeleted()){
						reposts.remove(repost);
					}
				}
				return tweetMapper.entitiesToDto(reposts);
			}
		else{
			throw new NotFoundException("This tweet does not exist");
		}
	}
}
