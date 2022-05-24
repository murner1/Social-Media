package com.cooksys.SocialMedia.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.services.TweetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("tweets")

@AllArgsConstructor
public class TweetController {
	private TweetService tweetService;

}
