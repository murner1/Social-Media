package com.cooksys.SocialMedia.Services.Impl;

import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.Tweet;
import com.cooksys.SocialMedia.Entities.User;
import com.cooksys.SocialMedia.Exceptions.NotFoundException;
import com.cooksys.SocialMedia.Mappers.TweetMapper;
import com.cooksys.SocialMedia.Mappers.UserMapper;
import com.cooksys.SocialMedia.Repositories.TweetRepository;
import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Repositories.UserRepository;
import com.cooksys.SocialMedia.Services.UserService;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;

	private UserMapper userMapper;

	private TweetMapper tweetMapper;
	@Override
	public List<UserResponseDto> getAllusers() {
		return userMapper.entititesToDto(userRepository.findAll());
	}

	@Override
	public List<TweetResponseDto> getFeed(String username) {
		Optional<User> user = userRepository.findByCredentialsUsername(username);
		List<User> following = user.get().getFollowing();
		if (user.isPresent()) {
			List<Tweet> tweets = user.get().getTweets();
			for(Tweet tweet : tweets){
				if(tweet.isDeleted()){
					tweets.remove(tweet);
				}
			}
			for(User users : following){
				List<Tweet> usersTweets = users.getTweets();
				for(Tweet tweet : usersTweets){
					if(!tweet.isDeleted()){
						tweets.add(tweet);
					}
				}
			}
			tweets.sort(Comparator.comparing(Tweet::getPosted));
			Collections.reverse(tweets);
			return tweetMapper.entitiesToDto(tweets);
		} else {
			throw new NotFoundException("That user does not exist");
		}
	}

	@Override
	public List<UserResponseDto> getFollowing(String username) {
		Optional<User> user = userRepository.findByCredentialsUsername(username);
		if(user.isPresent()){
			List<User> following = user.get().getFollowing();
			for(User users : following) {
				if (!user.isPresent()) {
					following.remove(user);
				}
			}
			return userMapper.entititesToDto(following);
		}
		else{
			throw new NotFoundException("this User does not exist");
		}
	}

	@Override
	public List<TweetResponseDto> getAuthoredTweets(String username) {
		Optional<User> user = userRepository.findByCredentialsUsername(username);
		if(user.isPresent()){
			List<Tweet> authored = user.get().getTweets();
			for(Tweet tweet : authored){
				if(tweet.isDeleted()){
					authored.remove(tweet);
				}
			}
			authored.sort(Comparator.comparing(Tweet::getPosted));
			Collections.reverse(authored);
			return tweetMapper.entitiesToDto(authored);
		}
		else{
			throw new NotFoundException("This User does not exist");
		}
	}
}
