package com.example.transaBuddy.domain.user.role;

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
