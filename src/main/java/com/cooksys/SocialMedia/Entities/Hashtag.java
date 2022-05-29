package com.cooksys.SocialMedia.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Hashtag {

    @Id
    @GeneratedValue
    private Long id;

    private String label;

    /*
     * Initializing the timestamps in your entities means you don't have to in the
     * services. The values will be overridden by JPA when pulling from the DB using
     * the setter.
     */
    @CreationTimestamp
    private Timestamp firstUsed = Timestamp.valueOf(LocalDateTime.now());

    @UpdateTimestamp
    private Timestamp lastUsed = Timestamp.valueOf(LocalDateTime.now());

    @ManyToMany(mappedBy = "hashtags")
    private List<Tweet> tweets = new ArrayList<>();

    public void addTweet(Tweet tweet) {
    	tweets.add(tweet);
    }
}
