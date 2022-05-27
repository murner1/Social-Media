package com.cooksys.SocialMedia.Services;

import com.cooksys.SocialMedia.Dtos.TweetRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;

public interface TweetService {

	TweetResponseDto postTweet(TweetRequestDto tweetRequestDto);

}
