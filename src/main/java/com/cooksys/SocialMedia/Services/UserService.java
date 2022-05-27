package com.cooksys.SocialMedia.Services;



<<<<<<< Updated upstream


import com.cooksys.SocialMedia.Dtos.CredentialsDto;

=======
import com.cooksys.SocialMedia.Dtos.CredentialsDto;
>>>>>>> Stashed changes
import com.cooksys.SocialMedia.Dtos.UserRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.User;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllUsers();


    UserResponseDto getUser(String username);

    UserResponseDto createUser(UserRequestDto userRequestDto);

  
    List<TweetResponseDto> getFeed(String username);

    List<UserResponseDto> getFollowing(String username);

    List<TweetResponseDto> getAuthoredTweets(String username);

    List<TweetResponseDto> getMentions(String username);

    List<UserResponseDto> getFollowers(String username);

<<<<<<< Updated upstream


    UserResponseDto updateUser(UserRequestDto userRequestDto);


    UserResponseDto followUser(UserRequestDto userRequestDto);

    UserResponseDto unfollowUser(UserRequestDto userRequestDto);

    UserResponseDto deleteUser(CredentialsDto credentialsDto, String username);

=======
    UserResponseDto updateUser(UserRequestDto userRequestDto);


    UserResponseDto deleteUser(CredentialsDto credentialsDto, String username);
>>>>>>> Stashed changes
}
