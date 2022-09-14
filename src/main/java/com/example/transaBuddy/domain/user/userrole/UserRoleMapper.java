package com.example.transaBuddy.domain.user.userrole;

import com.example.transaBuddy.transabuddy.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserRoleMapper {


    @Mapping(target = "user.id", source = "userId")
    UserRole responseToUserRole(UserResponse response);
}
