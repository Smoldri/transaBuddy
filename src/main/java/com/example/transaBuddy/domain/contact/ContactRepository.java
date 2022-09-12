package com.example.transaBuddy.domain.contact;

import com.example.transaBuddy.temp.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {


}