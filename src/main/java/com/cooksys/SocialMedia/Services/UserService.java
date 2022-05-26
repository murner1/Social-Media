package com.cooksys.SocialMedia.Services;


import com.cooksys.SocialMedia.Dtos.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getAllusers();

    UserResponseDto getUser(String username);
}
