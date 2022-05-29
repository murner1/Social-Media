package com.cooksys.SocialMedia.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.cooksys.SocialMedia.Embeddable.Credentials;
import com.cooksys.SocialMedia.Embeddable.Profile;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user_table")
public class User implements Deletable {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Credentials credentials;

    @CreationTimestamp
    private Timestamp joined = Timestamp.valueOf(LocalDateTime.now());

    private boolean deleted = false;

    @Embedded
    private Profile profile;

    @OneToMany(mappedBy = "author")
    private List<Tweet> tweets;

    @ManyToMany
    @JoinTable(name = ("followers_following"), joinColumns = @JoinColumn(name = "follower_id"))
    private List<User> followers;

    @ManyToMany(mappedBy = "followers")
    private List<User> following;

    @ManyToMany(mappedBy = "userLikes")
    private List<Tweet> likes;

    @ManyToMany(mappedBy = "usersMentioned")
    private List<Tweet> mentions;
    
    public void addMention(Tweet tweet) {
    	mentions.add(tweet);
    }

}
