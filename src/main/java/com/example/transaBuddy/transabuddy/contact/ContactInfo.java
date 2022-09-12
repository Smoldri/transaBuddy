package com.example.transaBuddy.transabuddy.contact;

import com.example.transaBuddy.temp.UserRole;
import lombok.Data;

import java.util.List;

@Data
public class ContactInfo {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String personalCode;
    private String phoneNumber;
    private String email;
    private List<String> roleNames;
}
