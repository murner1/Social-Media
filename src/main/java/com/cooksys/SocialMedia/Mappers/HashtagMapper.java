package com.cooksys.SocialMedia.Mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Entities.Hashtag;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagMapper {
	
	Hashtag dtoToEntity(HashtagDto hashtagDto);
	
	HashtagDto entityToDto(Hashtag hashtag);
	
	List<HashtagDto> entitiesToDtos(List<Hashtag> hashtags);

	List<HashtagDto> entitiesToDto(List<Hashtag> all);

}
