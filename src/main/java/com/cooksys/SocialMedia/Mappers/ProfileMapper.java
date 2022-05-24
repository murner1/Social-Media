package com.cooksys.SocialMedia.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.SocialMedia.Dtos.ProfileDto;
import com.cooksys.SocialMedia.Embeddable.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
	
	Profile dtoToEntity(ProfileDto profileDto);
	
	ProfileDto entityToDto(Profile profile);
}
