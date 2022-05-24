package com.cooksys.SocialMedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.SocialMedia.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
