package com.cooksys.SocialMedia.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.SocialMedia.Dtos.TweetRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Entities.Tweet;

@Mapper(componentModel = "spring")
public interface TweetMapper {
	
	Tweet requestDtoToEntity(TweetRequestDto tweetRequestDto);
	
	TweetResponseDto entityToResponseDto(Tweet tweet);
}
