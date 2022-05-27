package com.cooksys.SocialMedia.Controllers;

import com.cooksys.SocialMedia.Dtos.CredentialsDto;
import com.cooksys.SocialMedia.Dtos.UserRequestDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.User;
import org.springframework.web.bind.annotation.*;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Entities.User;

import com.cooksys.SocialMedia.Services.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
	private UserService userService;


	@GetMapping
	public List<UserResponseDto> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/@{username}")
	public UserResponseDto getAllActiveUsers(@PathVariable String username){
		return userService.getUser(username);
	}

	@PostMapping
	public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
		return userService.createUser(userRequestDto);
	}


	@GetMapping("@{username}/feed")
	public List<TweetResponseDto> getFeed(@PathVariable String username){
		return userService.getFeed(username);
	}
	@GetMapping("@{username}/following")
	public List<UserResponseDto> getFollowing(@PathVariable String username){
		return userService.getFollowing(username);
	}
	@GetMapping("@{username}/tweets")
	public List<TweetResponseDto> getAuthoredTweets(@PathVariable String username){
		return userService.getAuthoredTweets(username);
	}
	@GetMapping("@{username}/mentions")
	public List<TweetResponseDto> getMentions(@PathVariable String username){
		return userService.getMentions(username);
	}
	@GetMapping("@{username}/followers")
	public List<UserResponseDto> getFollowers(@PathVariable String username){
		return userService.getFollowers(username);
	}


	@PatchMapping("/@{username}")
	public UserResponseDto updateUser(@RequestBody UserRequestDto userRequestDto){
		return userService.updateUser(userRequestDto);
	}


	@DeleteMapping("/@{username}")
	public UserResponseDto deleteUser(@RequestBody CredentialsDto credentialsDto, @PathVariable String username){
		return userService.deleteUser(credentialsDto, username);
	}


	@PostMapping("/@{username}/follow")
	public UserResponseDto followUser(@RequestBody UserRequestDto userRequestDto){
		return userService.followUser(userRequestDto);
	}


	@PostMapping("/@{username}/unfollow")
	public UserResponseDto unfollowUser(@RequestBody UserRequestDto userRequestDto){
		return userService.unfollowUser(userRequestDto);
	}


}
