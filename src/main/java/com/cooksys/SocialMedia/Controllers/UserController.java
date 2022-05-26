package com.cooksys.SocialMedia.Controllers;

import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.Services.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
	private UserService userService;

	//GET users
	@GetMapping
	public List<UserResponseDto> getAllUsers(){
		return userService.getAllusers();
	}
	//GET users/@{username}
	@GetMapping("/@{username}")
	public UserResponseDto getAllActiveUsers(@PathVariable String username){
		return userService.getUser(username);
	}


}
