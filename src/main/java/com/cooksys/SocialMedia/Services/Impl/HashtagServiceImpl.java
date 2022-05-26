package com.cooksys.SocialMedia.Services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Mappers.HashtagMapper;
import com.cooksys.SocialMedia.Repositories.HashtagRepository;
import com.cooksys.SocialMedia.Services.HashtagService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HashtagServiceImpl implements HashtagService {
	
	private HashtagRepository hashtagRepository;
	private HashtagMapper hashtagMapper;

	@Override
	public List<HashtagDto> getAllTags() {
		return hashtagMapper.entitiesToDtos(hashtagRepository.findAll());
	}

}
