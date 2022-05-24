package com.cooksys.SocialMedia.Embeddable;


import javax.persistence.Embeddable;

@Embeddable
public class Profile {
    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
