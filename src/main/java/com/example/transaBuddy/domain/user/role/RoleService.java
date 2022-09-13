package com.example.transaBuddy.domain.user.role;

import com.example.transaBuddy.domain.user.role.RoleRepository;
import com.example.transaBuddy.temp.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;

    public Role getRoleByRoleId(Integer roleId) {
      return roleRepository.getRoleByRoleId(roleId);
    }
}
