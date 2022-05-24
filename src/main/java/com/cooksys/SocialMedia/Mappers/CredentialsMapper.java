package com.cooksys.SocialMedia.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.SocialMedia.Dtos.CredentialsDto;
import com.cooksys.SocialMedia.Embeddable.Credentials;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {
	
	Credentials dtoToEntity(CredentialsDto credentialsDto);
	
	CredentialsDto entityToDto(Credentials credentials);
}
