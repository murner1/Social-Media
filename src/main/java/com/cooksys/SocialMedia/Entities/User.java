package com.cooksys.SocialMedia.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Data

@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private String username;

    @Embedded
    private String password;

    private Timestamp joined;

    private Boolean deleted;

    @Embedded
    private String firstName;

    @Embedded
    private String lastName;

    @Embedded
    private String phone;

    @Embedded
    private String email;

    @ManyToMany
    @JoinTable(
            name = ("followers_following"),
            joinColumns = @JoinColumn(name = "follower_id")
    )
    private List<User> followers;

    @ManyToMany(mappedBy = "followers")
    private List<User> following;

    @ManyToMany
    @JoinTable(
            name = ("user_likes"),
            joinColumns = @JoinColumn(name = "tweet_id")
    )
    private List<Tweet> likes;

    @ManyToMany
    @JoinTable(
            name = ("user_mentions"),
            joinColumns = @JoinColumn(name = "tweet_id")
    )
    private List<Tweet> mentions;

    @OneToMany(mappedBy = "author")
    @JoinColumn(name = "author")
    private List<Tweet> tweets;
}

