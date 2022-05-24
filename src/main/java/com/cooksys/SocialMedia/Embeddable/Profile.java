package com.cooksys.SocialMedia.Embeddable;


import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Embeddable;

@Embeddable
public class Profile {
    @NotNull
    private String email;

    private String firstName;

    private String lastName;

    private String phone;
}
