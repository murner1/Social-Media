package com.cooksys.SocialMedia.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.Dtos.TweetRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Services.TweetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("tweets")

@AllArgsConstructor
public class TweetController {
	private TweetService tweetService;

	// Post Tweets
	// Creates a new simple tweet, with the author set to the user identified by the
	// credentials in the request body. If the given credentials do not match an
	// active user in the database, an error should be sent in lieu of a response.
	// must have content cannot have inReplyTo or repostOf

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TweetResponseDto postTweet(@RequestBody TweetRequestDto tweetRequestDto) {
		return tweetService.postTweet(tweetRequestDto);
	}

}
