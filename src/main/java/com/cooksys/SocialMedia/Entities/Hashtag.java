package com.cooksys.SocialMedia.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Hashtag {

    @Id
    @GeneratedValue
    private Long id;

    private String label;

    private Timestamp firstUsed;

    private Timestamp lastUsed;

    @ManyToMany
    @JoinTable(
            name = ("tweet_hashtags"),
            joinColumns = @JoinColumn(name = "tweet_id")
    )
    private List<Tweet> tweets;

}
