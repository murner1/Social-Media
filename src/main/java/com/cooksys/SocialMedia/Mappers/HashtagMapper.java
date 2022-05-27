package com.cooksys.SocialMedia.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.SocialMedia.Dtos.HashtagDto;
import com.cooksys.SocialMedia.Entities.Hashtag;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagMapper {
	
	Hashtag dtoToEntity(HashtagDto hashtagDto);
	
	HashtagDto entityToDto(Hashtag hashtag);

	List<HashtagDto> entitiesToDto(List<Hashtag> all);

}
