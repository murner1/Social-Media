package com.cooksys.SocialMedia.Dtos;

import com.cooksys.SocialMedia.Embeddable.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class UserResponseDto {

    private String username;

    private Profile profile;

    private Timestamp joined;
}
