package com.cooksys.SocialMedia.Services.Impl;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Repositories.HashtagRepository;
import com.cooksys.SocialMedia.Services.HashtagService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HashtagServiceImpl implements HashtagService{
	private HashtagRepository hashtagRepository;
	

}
