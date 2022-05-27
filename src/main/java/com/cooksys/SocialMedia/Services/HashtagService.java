package com.cooksys.SocialMedia.Services;

import com.cooksys.SocialMedia.Dtos.HashtagDto;

import java.util.List;

public interface HashtagService {

    List<HashtagDto> getTags(Long id);
}
