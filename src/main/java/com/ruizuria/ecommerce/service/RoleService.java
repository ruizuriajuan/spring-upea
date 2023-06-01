package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.entity.Role;
import com.ruizuria.ecommerce.exception.RoleDuplicated;
import com.ruizuria.ecommerce.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role getByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Role not found"));
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role create(Role role) {
        boolean foundRole = roleRepository.findByName(role.getName()).isPresent();
        if (foundRole) {
            throw new RoleDuplicated(role.getName());
        }
        return roleRepository.save(role);

    }

}
