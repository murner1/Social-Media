package com.cooksys.SocialMedia.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.Dtos.CredentialsDto;
import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Dtos.TweetRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Services.HashtagService;
import com.cooksys.SocialMedia.Services.TweetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("tweets")

@AllArgsConstructor
public class TweetController {
	private TweetService tweetService;

	private HashtagService hashtagService;

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
	
	//Repost tweet endpoint
	@PostMapping("/{id}/repost")
	public TweetResponseDto repostTweet(@RequestBody CredentialsDto credentialsDto, @PathVariable Long id) {
		return tweetService.repostTweet(credentialsDto, id);
	} 

	//Reply to a tweet
	@PostMapping("/{id}/reply")
	public TweetResponseDto replyToTweet(@RequestBody TweetRequestDto tweetRequestDto, @PathVariable Long id) {
		return tweetService.replyToTweet(tweetRequestDto,id);
	}
	
	
	@GetMapping
	public List<TweetResponseDto> getAllTweets() {
		return tweetService.getAllTweets();

	}

	@GetMapping("{id}")
	public TweetResponseDto getTweetById(@PathVariable Long id) {
		return tweetService.getTweetById(id);
	}

	@GetMapping("{id}/mentions")
	public List<UserResponseDto> getMentions(@PathVariable Long id) {
		return tweetService.getMentions(id);
	}

	@GetMapping("{id}/reposts")
	public List<TweetResponseDto> getReposts(@PathVariable Long id) {
		return tweetService.getReposts(id);
	}

	@GetMapping("{id}/replies")
	public List<TweetResponseDto> getReplies(@PathVariable Long id) {
		return tweetService.getReplies(id);
	}

	@GetMapping("{id}/likes")
	public List<UserResponseDto> getLikes(@PathVariable Long id) {
		return tweetService.getLikes(id);
	}

	@GetMapping("{id}/tags")
	public List<HashtagDto> getTags(@PathVariable Long id) {
		return hashtagService.getTags(id);
	}

	@DeleteMapping("/{id}")
	public TweetResponseDto deleteTweet(@RequestBody CredentialsDto credentialsDto, @PathVariable Long id) {
		return tweetService.deleteTweet(credentialsDto, id);
	}
	
	

}
