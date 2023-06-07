package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.entity.User;
import com.ruizuria.ecommerce.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;


    public String authenticate(String user, String password){
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user,password);
        Authentication authResult = authenticationManager.authenticate(auth);
        User userPrincipal = (User) authResult.getPrincipal();
        String accessToken = jwtService.createToken(userPrincipal);
        return accessToken;
    }
}
