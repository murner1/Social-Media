package com.cooksys.SocialMedia.services.impl;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.repositories.UserRepository;
import com.cooksys.SocialMedia.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;

}
