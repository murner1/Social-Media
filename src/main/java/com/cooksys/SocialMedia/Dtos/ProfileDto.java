package com.cooksys.SocialMedia.Dtos;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProfileDto {
    private String firstName;

    private String lastName;

    @NotNull
    private String email;

    private String phone;
}
