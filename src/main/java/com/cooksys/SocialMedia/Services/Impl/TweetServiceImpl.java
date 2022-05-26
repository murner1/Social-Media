package com.cooksys.SocialMedia.Services.Impl;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Dtos.TweetRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Entities.Tweet;
import com.cooksys.SocialMedia.Exceptions.BadRequestException;
import com.cooksys.SocialMedia.Mappers.HashtagMapper;
import com.cooksys.SocialMedia.Mappers.TweetMapper;
import com.cooksys.SocialMedia.Repositories.TweetRepository;
import com.cooksys.SocialMedia.Services.TweetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TweetServiceImpl implements TweetService {
	private TweetRepository tweetRepository;
	private TweetMapper tweetMapper;

	@Override
	public TweetResponseDto postTweet(TweetRequestDto tweetRequestDto) {
		// need to check that the credentials match an active user, if not send an error
		// For now we don't need to check that it does not have inReplyTo or repostOf
		// because tweetRequestDto only has content and credentials
		
		// Check that the tweet has content
		if(tweetRequestDto.getContent()==null) {
			throw new BadRequestException("Content is required for posting a tweet");
		}
		
		Tweet tweetToSaveTweet = tweetMapper.requestDtoToEntity(tweetRequestDto);
		// need to get the author of the tweet from the credentials
		// need to scan through the tweeet for @{username} and #{hastag} and add these
		// to the hashtags and usersMentioned lists
		
		
		
		// Save the tweet and and return it
		return tweetMapper.entityToResponseDto(tweetRepository.saveAndFlush(tweetToSaveTweet));
	}
}
