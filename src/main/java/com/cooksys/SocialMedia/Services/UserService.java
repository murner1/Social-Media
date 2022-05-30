package com.cooksys.SocialMedia.Services;



import com.cooksys.SocialMedia.Dtos.CredentialsDto;
import com.cooksys.SocialMedia.Dtos.UserRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;

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

    UserResponseDto deleteUser(CredentialsDto credentialsDto, String username);


    UserResponseDto updateUser(UserRequestDto userRequestDto, String username);

    void followUser(CredentialsDto credentialsDto, String username);

    void unfollowUser(CredentialsDto credentialsDto, String username);
}
