package com.cooksys.SocialMedia.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.User;

@Mapper(componentModel = "spring", uses = { ProfileMapper.class, CredentialsMapper.class })
public interface UserMapper {

    @Mapping(target = "username", source = "credentials.username")
    UserResponseDto entityToDto(User entity);
    
    




}
