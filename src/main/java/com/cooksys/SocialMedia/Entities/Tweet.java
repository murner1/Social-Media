package com.cooksys.SocialMedia.Entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User author;

    private Timestamp posted = Timestamp.valueOf(LocalDateTime.now());

    private boolean deleted = false;

    private String content;

    @ManyToOne
    @JoinColumn
    private Tweet inReplyTo;

    @ManyToOne
    @JoinColumn
    private Tweet repostOf;

    @OneToMany(mappedBy = "inReplyTo")
    private List<Tweet> replies = new ArrayList<>();

    @OneToMany(mappedBy = "repostOf")
    private List<Tweet> reposts = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<Hashtag> hashtags = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<User> userLikes = new ArrayList<>();

    @ManyToMany
    @JoinTable
    private List<User> usersMentioned = new ArrayList<>();

}
