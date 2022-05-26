package com.cooksys.SocialMedia.Services.Impl;

import com.cooksys.SocialMedia.Entities.Hashtag;
import com.cooksys.SocialMedia.Entities.User;
import com.cooksys.SocialMedia.Repositories.HashtagRepository;
import com.cooksys.SocialMedia.Repositories.UserRepository;
import com.cooksys.SocialMedia.Services.ValidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ValidateServiceImpl implements ValidateService {

    private final HashtagRepository hashtagRepository;

    private final UserRepository userRepository;

    @Override
    public boolean labelExists(String label) {
        Optional<Hashtag> optionalHashtag = hashtagRepository.findByLabel(label);
        return optionalHashtag.isPresent();

    }

    @Override
    public boolean usernameExists(String username) {
        Optional<User> optionalUsername = userRepository.findByCredentialsUsername(username);
        return optionalUsername.isPresent();
    }

    @Override
    public boolean usernameAvailable(String username) {
        Optional<User> optionalUsername = userRepository.findByCredentialsUsername(username);
        return !optionalUsername.isPresent();
    }

}
