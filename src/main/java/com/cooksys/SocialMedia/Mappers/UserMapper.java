package com.cooksys.SocialMedia.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.SocialMedia.Dtos.UserRequestDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.User;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ProfileMapper.class, CredentialsMapper.class })
public interface UserMapper {

    @Mapping(target = "username", source = "credentials.username")
    UserResponseDto entityToDto(User entity);
    
    
    User dtoToEntity(UserRequestDto userRequestDto);


    List<UserResponseDto> entititesToDto(List<User> all);

    User requestDtoToEntity(UserRequestDto userRequestDto);

    User responseDtoToEntity(String username);
}
