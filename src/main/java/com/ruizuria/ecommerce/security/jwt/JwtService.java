package com.ruizuria.ecommerce.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ruizuria.ecommerce.entity.User;
import com.ruizuria.ecommerce.security.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
@Service
public class JwtService {
    @Value("${spring.jwt.secret-key}")
    private String secretKey;
    @Autowired
    private UserDetailService userDetailService;

    public String createToken(User user) {
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("role", user.getRole().getName())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30)))
                .sign(Algorithm.HMAC256(secretKey));
    }

    public User decodeToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        DecodedJWT decodedJWT = verifier.verify(token); //recuperamos el payload
        String email = decodedJWT.getSubject(); //nuestro usuario es el email
        return (User) userDetailService.loadUserByUsername(email);
    }


}
