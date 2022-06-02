package com.cooksys.SocialMedia.Services;

import com.cooksys.SocialMedia.Dtos.CredentialsDto;
import com.cooksys.SocialMedia.Dtos.TweetRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.User;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

public interface TweetService {
  
    TweetResponseDto postTweet(TweetRequestDto tweetRequestDto);

    List<UserResponseDto> getMentions(Long id);

    List<TweetResponseDto> getReposts(Long id);

    List<TweetResponseDto> getReplies(Long id);

    List<UserResponseDto> getLikes(Long id);

    TweetResponseDto getTweetById(Long id);

    List<TweetResponseDto> getContext(Long id);
  
	List<TweetResponseDto> getAllTweets();

	TweetResponseDto deleteTweet(CredentialsDto credentialsDto, Long id);
	
	TweetResponseDto repostTweet(CredentialsDto credentialsDto, Long id);
	
	TweetResponseDto replyToTweet(TweetRequestDto tweetRequestDto,Long id);
	
	Void likeTweet(CredentialsDto credentialsDto,Long id);
	
	List<TweetResponseDto> getTweetsWithTag(String label);
}
