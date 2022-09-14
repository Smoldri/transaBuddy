package com.example.transaBuddy.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.contact.id = ?1")
    User getUserByContactId(Integer contactId);

    @Query("select u from User u where u.id = ?1")
    User getUserByUserId(Integer userId);
}