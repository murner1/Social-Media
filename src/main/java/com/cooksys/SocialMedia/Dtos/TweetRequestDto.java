package com.cooksys.SocialMedia.Dtos;

import java.sql.Timestamp;
import java.util.Date;

import com.cooksys.SocialMedia.Entities.Tweet;
import com.cooksys.SocialMedia.Entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NoArgsConstructor
@Data

public class TweetRequestDto {
    private int id;

    private UserRequestDto author;

    private Timestamp posted;

    private String content;

    private ContextDto inReplyTo;

    private ContextDto repostOf;







}
