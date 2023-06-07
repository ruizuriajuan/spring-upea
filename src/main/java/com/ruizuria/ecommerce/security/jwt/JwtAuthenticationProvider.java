package com.ruizuria.ecommerce.security.jwt;

import com.ruizuria.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private JwtService jwtService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken auth = (JwtAuthenticationToken) authentication;
        String token = (String) auth.getPrincipal();
        User user = jwtService.decodeToken(token);
        Object principalToReturn = user;
        return new JwtAuthenticationToken(principalToReturn, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
