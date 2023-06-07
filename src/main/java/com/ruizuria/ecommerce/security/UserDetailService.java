package com.ruizuria.ecommerce.security;

import com.ruizuria.ecommerce.entity.User;
import com.ruizuria.ecommerce.repository.UserRepository;
import com.ruizuria.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFound = repository.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
        return userFound;
    }
}
