package com.example.transaBuddy.domain.contact;

import com.example.transaBuddy.temp.Contact;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import com.example.transaBuddy.transabuddy.user.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact userRequestToContact (UserRequest userRequest);
    @Mapping(target = "contactId", source = "id")
    List<ContactInfo> contactToContactInfos(List<Contact> contacts);

}
