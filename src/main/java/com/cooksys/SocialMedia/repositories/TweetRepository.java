package com.cooksys.SocialMedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.SocialMedia.Entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long>{

}
