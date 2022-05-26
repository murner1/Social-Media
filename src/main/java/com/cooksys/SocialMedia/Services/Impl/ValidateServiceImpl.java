package com.cooksys.SocialMedia.Services.Impl;

import com.cooksys.SocialMedia.Entities.Hashtag;
import com.cooksys.SocialMedia.Repositories.HashtagRepository;
import com.cooksys.SocialMedia.Services.ValidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ValidateServiceImpl implements ValidateService {

private final HashtagRepository hashtagRepository;
    @Override
    public boolean labelExists(String label) {
        Optional<Hashtag> optionalHashtag = hashtagRepository.findByLabel(label);
        return optionalHashtag.isPresent();

    }
}
