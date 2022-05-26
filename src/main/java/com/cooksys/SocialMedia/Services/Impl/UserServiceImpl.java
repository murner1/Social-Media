package com.cooksys.SocialMedia.Services.Impl;

import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.User;
import com.cooksys.SocialMedia.Exceptions.NotFoundException;
import com.cooksys.SocialMedia.Mappers.UserMapper;
import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Repositories.UserRepository;
import com.cooksys.SocialMedia.Services.UserService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;

	private UserMapper userMapper;
	@Override
	public List<UserResponseDto> getAllusers() {
		return userMapper.entititesToDto(userRepository.findAllByDeleted(false));
	}

	@Override
	public UserResponseDto getUser(String username) {
		Optional<User> optionalUserName = userRepository.findByCredentialsUsername(username);
		if(!optionalUserName.isPresent()){
			throw new NotFoundException("User " + username + " not found.");
		}
		if(optionalUserName.get().getDeleted()){
			throw new NotFoundException("User " + username + " is deleted.");
		}
		return userMapper.entityToDto(optionalUserName.get());
	}


}
