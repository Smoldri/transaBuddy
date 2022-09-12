package com.example.transaBuddy.domain.contact;

import com.example.transaBuddy.domain.user.UserService;
import com.example.transaBuddy.temp.Contact;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.user.UserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;

    @Resource
    private UserService userService;


    public Contact addContact(UserRequest request) {
        Contact contact = contactMapper.userRequestToContact(request);
        contactRepository.save(contact);
        return contact;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<ContactInfo> mapContactsToContactInfosAndUpdateUserIds(List<Contact> contacts) {
        System.out.println();
        List<ContactInfo> contactInfos = contactMapper.contactToContactInfos(contacts);
        userService.updateContactsInfosWithUserIds(contactInfos);
        return contactInfos;
    }
}

