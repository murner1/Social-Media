package com.cooksys.SocialMedia.Mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Entities.Hashtag;

@Mapper(componentModel = "spring")
public interface HashtagMapper {
	
	Hashtag dtoToEntity(HashtagDto hashtagDto);
	
	HashtagDto entityToDto(Hashtag hashtag);
	
	List<HashtagDto> entitiesToDtos(List<Hashtag> hashtags);

}
