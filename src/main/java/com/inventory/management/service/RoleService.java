package com.inventory.management.service;

//import com.youtube.jwt.dao.RoleDao;

import com.inventory.management.model.Role;
import com.inventory.management.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
