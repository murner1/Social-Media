package com.cooksys.SocialMedia.Repositories;

import com.cooksys.SocialMedia.Entities.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.SocialMedia.Entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    //Optional<User> findByLabel(String username);

}
