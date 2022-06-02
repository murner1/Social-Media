package com.cooksys.SocialMedia.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Services.HashtagService;
import com.cooksys.SocialMedia.Services.TweetService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("tags")
@AllArgsConstructor
public class HashtagController {
  private HashtagService hashtagService;
  private TweetService tweetService;

  //Get tags
  @GetMapping
  public List<HashtagDto> getAllTags(){
	  return hashtagService.getAllTags();
  }
  
  @GetMapping("{label}")
  public List<TweetResponseDto> getTags(@PathVariable String label){
		return tweetService.getTweetsWithTag(label);
	}
  
}
