package com.cooksys.SocialMedia.services.impl;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.repositories.TweetRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TweetServiceImpl {
	private TweetRepository tweetRepository;
}
