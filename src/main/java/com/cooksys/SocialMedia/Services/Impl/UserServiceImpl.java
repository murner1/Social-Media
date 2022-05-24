package com.cooksys.SocialMedia.Services.Impl;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Repositories.UserRepository;
import com.cooksys.SocialMedia.Services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;

}
