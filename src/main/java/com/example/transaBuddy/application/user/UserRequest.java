package com.example.transaBuddy.application.user;

import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String personalCode;
    private String phoneNumber;
    private String email;
    private int roleId;
}
