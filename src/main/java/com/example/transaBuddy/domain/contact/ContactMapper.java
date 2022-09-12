package com.example.transaBuddy.domain.contact;

import com.example.transaBuddy.temp.Contact;
import com.example.transaBuddy.transabuddy.user.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    Contact userRequestToContact (UserRequest userRequest);
}
