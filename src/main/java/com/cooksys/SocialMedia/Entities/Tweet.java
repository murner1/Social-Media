package com.cooksys.SocialMedia.Entities;

import java.security.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Tweet {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Integer author;
	
	private Timestamp posted;
	
	private boolean deleted;
	
	private String content;
	
	
	private Integer	inReplyTo;
	
	
	private Integer repostOf;
	
	@ManyToMany
	private List<Hashtag> hashtags;
	
	@ManyToMany
	private List<User> userLikes;
	
	@ManyToMany 
	private List<User> userMentiones;
	
	

}
