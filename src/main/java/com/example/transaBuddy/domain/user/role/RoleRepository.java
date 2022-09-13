package com.example.transaBuddy.domain.user.role;

import com.example.transaBuddy.temp.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.id = ?1")
    Role getRoleByRoleId(Integer id);

}