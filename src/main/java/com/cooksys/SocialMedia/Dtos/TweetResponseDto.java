package com.cooksys.SocialMedia.Dtos;

import com.cooksys.SocialMedia.Entities.Tweet;
import com.cooksys.SocialMedia.Entities.User;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class TweetResponseDto {
    @NotNull
    private Long id;
    @NotNull
    private User author;
    @NotNull
    private Timestamp posted;

    private String content;

    private Tweet inReplyTo;

    private Tweet repostOf;
}
