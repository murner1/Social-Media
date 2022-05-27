package com.cooksys.SocialMedia.Services.Impl;

import com.cooksys.SocialMedia.Dtos.UserRequestDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Embeddable.Credentials;
import com.cooksys.SocialMedia.Entities.User;
import com.cooksys.SocialMedia.Exceptions.BadRequestException;
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
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	private UserMapper userMapper;

	@Override
	public List<UserResponseDto> getAllusers() {
		return userMapper.entititesToDto(userRepository.findAllByDeleted(false));
	}

	@Override
	public UserResponseDto getUser(String username) {
		Optional<User> optionalUserName = userRepository.findByCredentialsUsername(username);
		if (!optionalUserName.isPresent()) {
			throw new NotFoundException("User " + username + " not found.");
		}
		if (optionalUserName.get().getDeleted()) {
			throw new NotFoundException("User " + username + " is deleted.");
		}
		return userMapper.entityToDto(optionalUserName.get());
	}

	@Override
	public UserResponseDto createUser(UserRequestDto userRequestDto) {
		User userToCreate = userMapper.requestDtoToEntity(userRequestDto);
		Optional<User> optionalUser = userRepository.findByCredentialsUsername(userRequestDto.getCredentials().getUsername());
		if (userToCreate.getCredentials().getPassword() == null || userToCreate.getCredentials().getUsername() == null || userToCreate.getProfile().getEmail() == null) {
			throw new NotFoundException("Password or username not valid");
		}
		if (optionalUser.isPresent()) {
			if (!optionalUser.get().getDeleted()) {
				throw new BadRequestException("User already exists");
			} else {
				optionalUser.get().setDeleted(false);  //Taking the optional user and setting delete to false
				userRepository.saveAndFlush(optionalUser.get());
				return userMapper.entityToDto(optionalUser.get()); //Need mapper to go from user entitiy to Dto.
			}

		}
		User saveThisUser = userRepository.saveAndFlush(userToCreate);
		return userMapper.entityToDto(saveThisUser);

	}
}
