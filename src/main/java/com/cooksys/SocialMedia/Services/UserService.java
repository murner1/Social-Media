package com.cooksys.SocialMedia.Services;


import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllusers();

    List<TweetResponseDto> getFeed(String username);
}
