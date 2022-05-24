package com.cooksys.SocialMedia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.Services.TweetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tweets")

@AllArgsConstructor
public class TweetController {
	private TweetService tweetService;

}
