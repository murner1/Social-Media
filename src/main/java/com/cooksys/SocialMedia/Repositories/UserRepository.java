package com.cooksys.SocialMedia.Repositories;

import java.util.Optional;

import com.cooksys.SocialMedia.Entities.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCredentialsUsername(String username);


    List<User> findAllByDeleted(boolean deleted);

    List<User> findAllByDeletedFalse();


}
