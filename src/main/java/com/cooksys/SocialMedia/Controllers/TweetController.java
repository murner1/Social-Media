package com.cooksys.SocialMedia.Controllers;

import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Services.HashtagService;
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

	private HashtagService hashtagService;

	@GetMapping("{id}/mentions")
	public List<UserResponseDto> getMentions(@PathVariable Long id){
		return tweetService.getMentions(id);
	}
	@GetMapping("{id}/reposts")
	public List<TweetResponseDto> getReposts(@PathVariable Long id){
		return tweetService.getReposts(id);
	}
	@GetMapping("{id}/replies")
	public List<TweetResponseDto> getReplies(@PathVariable Long id){
		return tweetService.getReplies(id);
	}
	@GetMapping("{id}/likes")
	public List<UserResponseDto> getLikes(@PathVariable Long id){
		return tweetService.getLikes(id);
	}
	@GetMapping("{id}/tags")
	public List<HashtagDto> getTags(@PathVariable Long id){
		return hashtagService.getTags(id);
	}

}
