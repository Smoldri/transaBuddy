package com.example.transaBuddy.domain.contact;

import com.example.transaBuddy.temp.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("""
            select (count(c) > 0) from Contact c
            where upper(c.firstName) = upper(?1) and upper(c.lastName) = upper(?2) and upper(c.personalCode) = upper(?3)""")
    boolean existsBy(String firstName, String lastName, String personalCode);

    @Query("""
            select c from Contact c
            where c.firstName = ?1 and c.lastName = ?2 and c.personalCode = ?3
            order by c.lastName""")
    List<Contact> findByFirstNameAndLastNameAndPersonalCode(String firstName, String lastName, String personalCode);

    @Query("""
            select c from Contact c
            where upper(c.firstName) = upper(?1) or upper(c.lastName) = upper(?2) or upper(c.personalCode) = upper(?3)
            order by c.lastName""")
    List<Contact> findByFirstNameOrLastNameOrPersonalCode(String firstName, String lastName, String personalCode);

}




