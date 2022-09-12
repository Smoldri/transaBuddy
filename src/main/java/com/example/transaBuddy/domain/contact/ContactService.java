package com.example.transaBuddy.domain.contact;

import com.example.transaBuddy.temp.Contact;
import com.example.transaBuddy.transabuddy.user.UserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;


    public Contact addContact(UserRequest request) {
        Contact contact = contactMapper.userRequestToContact(request);
        contactRepository.save(contact);
        return contact;
    }
}
