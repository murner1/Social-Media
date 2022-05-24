package com.cooksys.SocialMedia.Services.Impl;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Repositories.TweetRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TweetServiceImpl {
	private TweetRepository tweetRepository;
}
