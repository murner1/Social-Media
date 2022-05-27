package com.cooksys.SocialMedia.Services.Impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserRequestDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.Deletable;

import com.cooksys.SocialMedia.Dtos.CredentialsDto;

import com.cooksys.SocialMedia.Entities.Tweet;
import com.cooksys.SocialMedia.Entities.User;
import com.cooksys.SocialMedia.Exceptions.BadRequestException;
import com.cooksys.SocialMedia.Exceptions.NotFoundException;
import com.cooksys.SocialMedia.Mappers.TweetMapper;
import com.cooksys.SocialMedia.Mappers.UserMapper;
import com.cooksys.SocialMedia.Repositories.UserRepository;
import com.cooksys.SocialMedia.Services.UserService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    private TweetMapper tweetMapper;

    private <T extends Deletable> List<T> filterDeleted(List<T> toFilter) {
        List<T> filtered = new ArrayList<>();
        for (T item : toFilter) {
            if (!item.isDeleted()) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    private List<Tweet> reverseChronological(List<Tweet> toSort) {
        List<Tweet> result = new ArrayList<>(toSort);
        result.sort(Comparator.comparing(Tweet::getPosted));
        Collections.reverse(result);
        return result;
    }

    private User findUser(String username) {
        Optional<User> user = userRepository.findByCredentialsUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NotFoundException("this User does not exist");
        }
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userMapper.entititesToDto(userRepository.findAllByDeleted(false));
    }

    @Override
    public UserResponseDto getUser(String username) {
        User user = findUser(username);
        if (user.isDeleted()) {
            throw new NotFoundException("this User does not exist");
        }
        return userMapper.entityToDto(user);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User userToCreate = userMapper.requestDtoToEntity(userRequestDto);
        Optional<User> optionalUser = userRepository
                .findByCredentialsUsername(userRequestDto.getCredentials().getUsername());
        if (userToCreate.getCredentials().getPassword() == null || userToCreate.getCredentials().getUsername() == null
                || userToCreate.getProfile().getEmail() == null) {
            throw new NotFoundException("Password or username not valid");
        }
        if (optionalUser.isPresent()) {
            if (!optionalUser.get().isDeleted()) {
                throw new BadRequestException("User already exists");
            } else {
                optionalUser.get().setDeleted(false); // Taking the optional user and setting delete to false
                userRepository.saveAndFlush(optionalUser.get());
                return userMapper.entityToDto(optionalUser.get()); // Need mapper to go from user entitiy to Dto.
            }

        }
        User saveThisUser = userRepository.saveAndFlush(userToCreate);
        return userMapper.entityToDto(saveThisUser);

    }

    @Override
    public List<TweetResponseDto> getFeed(String username) {
        User user = findUser(username);
        List<User> following = filterDeleted(user.getFollowing());
        List<Tweet> tweets = filterDeleted(user.getTweets());
        for (User followed : following) {
            tweets.addAll(filterDeleted(followed.getTweets()));
        }
        return tweetMapper.entitiesToDto(reverseChronological(tweets));
    }

    @Override
    public List<UserResponseDto> getFollowing(String username) {
        return userMapper.entititesToDto(filterDeleted(findUser(username).getFollowing()));
    }

    @Override
    public List<TweetResponseDto> getAuthoredTweets(String username) {
        return tweetMapper.entitiesToDto(reverseChronological(filterDeleted(findUser(username).getTweets())));
    }

    @Override
    public List<TweetResponseDto> getMentions(String username) {
        return tweetMapper.entitiesToDto(reverseChronological(filterDeleted(findUser(username).getMentions())));
    }

    @Override
    public List<UserResponseDto> getFollowers(String username) {
        return userMapper.entititesToDto(filterDeleted(findUser(username).getFollowers()));
    }


	@Override
	public UserResponseDto deleteUser(CredentialsDto credentialsDto, String username) {
		Optional<User> userToDelete = userRepository.findByCredentialsUsername(username);
		if (!userToDelete.isPresent() ||
				userToDelete.get().isDeleted() ||
				!userToDelete.get().getCredentials().getUsername().equals(credentialsDto.getUsername()) ||
				!userToDelete.get().getCredentials().getPassword().equals(credentialsDto.getPassword())) {
			throw new NotFoundException("User not found");
		}
		User deletingUser = userToDelete.get();
		deletingUser.setDeleted(true);

		for (Tweet tweet : deletingUser.getTweets()) {
			tweet.setDeleted(true);
		}
		userRepository.saveAndFlush(deletingUser);
		return userMapper.entityToDto(userToDelete.get());
	}

	//POST users/@{username}/follow
	@Override
	public UserResponseDto followUser(UserRequestDto userRequestDto) {
		return null;
	}

	//POST users/@{username}/unfollow
	@Override
	public UserResponseDto unfollowUser(UserRequestDto userRequestDto) {
		return null;
	}

	//PATCH users/@{username}*
	@Override
	public UserResponseDto updateUser(UserRequestDto userRequestDto) {
		User userToUpdate = userMapper.requestDtoToEntity(userRequestDto);
		Optional<User> updatingUser = userRepository.findByCredentialsUsername(userRequestDto.getCredentials().getUsername());
		if (!updatingUser.isPresent() ||
				updatingUser.get().isDeleted() ||
				!updatingUser.get().getCredentials().getUsername().equals(userRequestDto.getCredentials().getUsername()) ||
				!updatingUser.get().getCredentials().getPassword().equals(userToUpdate.getCredentials().getPassword())) {
			throw new NotFoundException("User not found.");
		}
		User updateThisUser = userRepository.saveAndFlush(userToUpdate);
		return userMapper.entityToDto((updateThisUser));
	}

}










