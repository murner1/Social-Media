package com.cooksys.SocialMedia.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data

@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private Timestamp joined;

    private Boolean deleted;

    @Embedded
    private String firstName;

    @Embedded
    private String lastName;

    @Embedded
    private String phoneNumber;

    @Embedded
    private String email;
}
