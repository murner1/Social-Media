package com.cooksys.SocialMedia.Controllers;

import com.cooksys.SocialMedia.Dtos.CredentialsDto;
import com.cooksys.SocialMedia.Dtos.UserRequestDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
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
	//POST users
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
	@DeleteMapping("@{username}")
	public UserResponseDto deleteUser(@RequestBody CredentialsDto credentialsDto, @PathVariable String username){
		return  userService.deleteUser(credentialsDto, username);
	}
	@PatchMapping("@{username}")
	public UserResponseDto updateUser(@RequestBody UserRequestDto userRequestDto, @PathVariable String username){
		return userService.updateUser(userRequestDto, username);
	}
	@PostMapping("@{username}/follow")
	public UserResponseDto followUser(@RequestBody UserRequestDto userRequestDto, @PathVariable String username){
		return userService.followUser(userRequestDto, username);
	}

	@PostMapping("@{username}/unfollow")
	public UserResponseDto unfollowUser(@RequestBody UserRequestDto userRequestDto, @PathVariable String username) {
		return userService.unfollowUser(userRequestDto, username);

	}


}
