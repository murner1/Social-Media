package com.cooksys.SocialMedia.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.SocialMedia.Entities.Hashtag;

import java.awt.*;
import java.util.Optional;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long>{

    Optional<Hashtag> findByLabel(String label);

}
