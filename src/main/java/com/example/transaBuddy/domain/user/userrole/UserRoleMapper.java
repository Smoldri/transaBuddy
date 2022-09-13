package com.example.transaBuddy.domain.user.userrole;

import com.example.transaBuddy.transabuddy.user.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserRoleMapper {

}
