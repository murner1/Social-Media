package com.cooksys.SocialMedia.Services.Impl;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Repositories.TweetRepository;
import com.cooksys.SocialMedia.Services.TweetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TweetServiceImpl implements TweetService{
	private TweetRepository tweetRepository;
}
