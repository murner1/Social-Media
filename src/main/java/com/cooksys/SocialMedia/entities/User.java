package com.cooksys.SocialMedia.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private Timestamp joined;

    private Boolean deleted;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}
