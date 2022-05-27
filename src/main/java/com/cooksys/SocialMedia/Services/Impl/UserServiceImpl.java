package com.cooksys.SocialMedia.Services.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.cooksys.SocialMedia.Dtos.TweetResponseDto;
import com.cooksys.SocialMedia.Dtos.UserResponseDto;
import com.cooksys.SocialMedia.Entities.Deletable;
import com.cooksys.SocialMedia.Entities.Tweet;
import com.cooksys.SocialMedia.Entities.User;
import com.cooksys.SocialMedia.Exceptions.NotFoundException;
import com.cooksys.SocialMedia.Mappers.TweetMapper;
import com.cooksys.SocialMedia.Mappers.UserMapper;
import com.cooksys.SocialMedia.Repositories.UserRepository;
import com.cooksys.SocialMedia.Services.UserService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private UserMapper userMapper;

    private TweetMapper tweetMapper;

    private <T extends Deletable> List<T> filterDeleted(List<T> toFilter) {
        List<T> filtered = new ArrayList<>();
        for (T item : toFilter) {
            if (!item.isDeleted()) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    private List<Tweet> reverseChronological(List<Tweet> toSort) {
        List<Tweet> result = new ArrayList<>(toSort);
        result.sort(Comparator.comparing(Tweet::getPosted));
        Collections.reverse(result);
        return result;
    }

    private User getUser(String username) {
        Optional<User> user = userRepository.findByCredentialsUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NotFoundException("this User does not exist");
        }
    }

    @Override
    public List<UserResponseDto> getAllusers() {
        return userMapper.entititesToDto(userRepository.findAll());
    }

    @Override
    public List<TweetResponseDto> getFeed(String username) {
        User user = getUser(username);
        List<User> following = filterDeleted(user.getFollowing());
        List<Tweet> tweets = filterDeleted(user.getTweets());
        for (User followed : following) {
            tweets.addAll(filterDeleted(followed.getTweets()));
        }
        return tweetMapper.entitiesToDto(reverseChronological(tweets));
    }

    @Override
    public List<UserResponseDto> getFollowing(String username) {
        return userMapper.entititesToDto(filterDeleted(getUser(username).getFollowing()));
    }

    @Override
    public List<TweetResponseDto> getAuthoredTweets(String username) {
        return tweetMapper.entitiesToDto(reverseChronological(filterDeleted(getUser(username).getTweets())));
    }

    @Override
    public List<TweetResponseDto> getMentions(String username) {
        return tweetMapper.entitiesToDto(reverseChronological(filterDeleted(getUser(username).getMentions())));
    }

    @Override
    public List<UserResponseDto> getFollowers(String username) {
        return userMapper.entititesToDto(filterDeleted(getUser(username).getFollowers()));
    }
}
