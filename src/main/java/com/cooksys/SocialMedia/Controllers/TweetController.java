package com.cooksys.SocialMedia.Controllers;

import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.Services.TweetService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("tweets")

@AllArgsConstructor
public class TweetController {
	private TweetService tweetService;

	@GetMapping("{id}/mentions")
	public List<UserResponseDto> getMentions(@PathVariable Long id){
		return tweetService.getMentions(id);
	}

}
