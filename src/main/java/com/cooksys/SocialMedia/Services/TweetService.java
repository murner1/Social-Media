package com.cooksys.SocialMedia.Services;

import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.User;

import java.util.List;

public interface TweetService {

    List<UserResponseDto> getMentions(Long id);
}
