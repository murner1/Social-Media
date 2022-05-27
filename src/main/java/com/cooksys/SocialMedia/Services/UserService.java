package com.cooksys.SocialMedia.Services;



import com.cooksys.SocialMedia.Dtos.UserRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.User;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllusers();

    UserResponseDto getUser(String username);

    UserResponseDto createUser(UserRequestDto userRequestDto);
  
    List<TweetResponseDto> getFeed(String username);

    List<UserResponseDto> getFollowing(String username);

    List<TweetResponseDto> getAuthoredTweets(String username);

    List<TweetResponseDto> getMentions(String username);

    List<UserResponseDto> getFollowers(String username);

}
