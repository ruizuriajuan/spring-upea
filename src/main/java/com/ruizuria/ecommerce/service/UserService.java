package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.dto.UserDto;
import com.ruizuria.ecommerce.entity.User;
import com.ruizuria.ecommerce.mapper.UserMapper;
import com.ruizuria.ecommerce.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public UserDto getById(Integer id) {
        User userFound = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toUserDto(userFound);
    }
}
