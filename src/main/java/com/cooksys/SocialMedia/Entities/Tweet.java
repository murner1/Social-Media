package com.cooksys.SocialMedia.Entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tweet implements Deletable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private User author;

	private Timestamp posted = Timestamp.valueOf(LocalDateTime.now());

	private boolean deleted = false;

	private String content;

	@ManyToOne
	@JoinColumn
	private Tweet inReplyTo;

	@ManyToOne
	@JoinColumn
	private Tweet repostOf;

	@OneToMany(mappedBy = "inReplyTo")
	private List<Tweet> replies = new ArrayList<>();

	@OneToMany(mappedBy = "repostOf")
	private List<Tweet> reposts = new ArrayList<>();

	@ManyToMany
	@JoinTable
	private List<Hashtag> hashtags = new ArrayList<>();

	@ManyToMany
	@JoinTable
	private List<User> userLikes = new ArrayList<>();

	@ManyToMany
	@JoinTable
	private List<User> usersMentioned = new ArrayList<>();
	
	public void addReply(Tweet tweet) {
		replies.add(tweet);
	}
	
	public void addRepost(Tweet tweet) {
		reposts.add(tweet);
	}
	
	public void addHashtag(Hashtag hashtag) {
		hashtags.add(hashtag);
	}
	
	public void addUserLike(User user) {
		userLikes.add(user);
	}
	
	public void addUserMention(User user) {
		usersMentioned.add(user);
	}

	public Tweet(User tweetAuthor, String content, List<Hashtag> hashtags, List<User> usersMentioned) {
		this.author = tweetAuthor;
		this.content = content;
		this.hashtags = hashtags;
		this.usersMentioned = usersMentioned;
	}
	
	public Tweet(User tweetAuthor, String content) {
		this.author = tweetAuthor;
		this.content = content;
		
	}
}
