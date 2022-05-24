package com.cooksys.SocialMedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.SocialMedia.Entities.Hashtag;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long>{
	


}
