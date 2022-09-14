package com.example.transaBuddy.domain.contact;

import com.example.transaBuddy.domain.user.UserService;
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


    public Contact createAndAddContact(UserRequest request) {
        Contact contact = contactMapper.userRequestToContact(request);
        contactRepository.save(contact);
        return contact;
    }


    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<ContactInfo> mapContactsToContactInfosAndUpdateUserIds(List<Contact> contacts) {
        List<ContactInfo> contactInfos = contactMapper.contactToContactInfos(contacts);
        userService.updateContactsInfosWithUserIds(contactInfos);
        userService.updateContactsInfosWithRoleNames(contactInfos);
        return contactInfos;
    }

    public List<Contact> findContacts(String firstName, String lastName, String personalCode) {
        boolean contactExists = contactRepository.existsBy(firstName, lastName, personalCode);
        if (contactExists){
            return contactRepository.findByFirstNameAndLastNameAndPersonalCode(firstName, lastName, personalCode);
        } else {
            return contactRepository.findByFirstNameOrLastNameOrPersonalCode(firstName, lastName, personalCode);
        }
    }
}

