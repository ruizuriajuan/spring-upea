package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.entity.Role;
import com.ruizuria.ecommerce.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role getByName(String name){
        return roleRepository.findByName(name).orElseThrow( ()-> new EntityNotFoundException("Role not found"));
    }

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

}
