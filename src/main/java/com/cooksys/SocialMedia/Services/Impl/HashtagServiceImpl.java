package com.cooksys.SocialMedia.Services.Impl;
import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Entities.Hashtag;
import com.cooksys.SocialMedia.Entities.Tweet;
import com.cooksys.SocialMedia.Exceptions.NotFoundException;
import com.cooksys.SocialMedia.Mappers.HashtagMapper;
import com.cooksys.SocialMedia.Repositories.TweetRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Repositories.HashtagRepository;
import com.cooksys.SocialMedia.Services.HashtagService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HashtagServiceImpl implements HashtagService {
	
	private HashtagRepository hashtagRepository;
	private HashtagMapper hashtagMapper;
  private TweetRepository tweetRepository;

	@Override
	public List<HashtagDto> getAllTags() {
		return hashtagMapper.entitiesToDtos(hashtagRepository.findAll());
	}

	@Override
	public List<HashtagDto> getTags(Long id) {
		Optional<Tweet> tweet = tweetRepository.findById(id);
		if (tweet.isPresent()){
			List<Hashtag> tags = tweet.get().getHashtags();
			return hashtagMapper.entitiesToDto(tags);
		}
		else{
			throw new NotFoundException("This tweet does not exist");
		}
	}
}
