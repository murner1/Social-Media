package com.cooksys.SocialMedia.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequestDto {
    private ProfileDto profile;

    private CredentialsDto credentials;
}
