package com.cooksys.SocialMedia.entities;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Tweet {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Integer author;
	
	private Timestamp posted;
	
	private boolean deleted;
	
	private String content;
	
	private Integer	inReplyTo;
	
	private Integer repostOf;
	

}
