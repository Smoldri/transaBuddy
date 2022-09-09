package com.example.transaBuddy.domain.user.userrole;

import com.example.transaBuddy.temp.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query("select u from UserRole u where u.user.userName = ?1 and u.user.password = ?2 order by u.role.id")
    List<UserRole> findUserRoleBy(String userName, String password);


}