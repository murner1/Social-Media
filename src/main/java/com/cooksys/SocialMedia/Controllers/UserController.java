package com.cooksys.SocialMedia.Controllers;

import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.User;
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
	public List<UserResponseDto> getAllUsers(){return userService.getAllusers();}

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


}
