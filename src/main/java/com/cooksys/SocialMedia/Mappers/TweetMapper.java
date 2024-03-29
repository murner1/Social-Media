package com.cooksys.SocialMedia.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.SocialMedia.Dtos.TweetRequestDto;
import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Entities.Tweet;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface TweetMapper {



    Tweet requestDtoToEntity(TweetRequestDto tweetRequestDto);

    TweetResponseDto entityToResponseDto(Tweet tweet);

    List<TweetResponseDto> entitiesToDto(List<Tweet> all);


}
