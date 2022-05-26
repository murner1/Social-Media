package com.cooksys.SocialMedia.Services.Impl;

import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Mappers.UserMapper;
import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Repositories.UserRepository;
import com.cooksys.SocialMedia.Services.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;

	private UserMapper userMapper;
	@Override
	public List<UserResponseDto> getAllusers() {
		return userMapper.entititesToDto(userRepository.findAll());
	}
}
