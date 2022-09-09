package com.example.transaBuddy.domain.user;

import com.example.transaBuddy.temp.User;
import com.example.transaBuddy.transabuddy.contact.ContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "firstName", source = "contact.firstName")
    @Mapping(target = "lastName", source = "contact.lastName")
    @Mapping(target = "personalCode", source = "contact.personalCode")
    @Mapping(target = "email", source = "contact.email")
    @Mapping(target = "phoneNumber", source = "contact.phoneNumber")
    ContactInfo userToContactInfo(User user);

}
