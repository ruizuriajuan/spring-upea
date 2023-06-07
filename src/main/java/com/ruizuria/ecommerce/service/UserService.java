package com.ruizuria.ecommerce.service;

import com.ruizuria.ecommerce.dto.EmailNotificationDto;
import com.ruizuria.ecommerce.dto.UserDto;
import com.ruizuria.ecommerce.entity.ConfirmationToken;
import com.ruizuria.ecommerce.entity.User;
import com.ruizuria.ecommerce.exception.EmailTaken;
import com.ruizuria.ecommerce.mapper.UserMapper;
import com.ruizuria.ecommerce.repository.UserRepository;
import com.ruizuria.ecommerce.util.HtmlGenerator;
import com.ruizuria.ecommerce.util.UriGenerator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleService roleService;
    @Autowired
    ConfirmationTokenService confirmationTokenService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;

    public UserDto getById(Integer id) {
        User userFound = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.toUserDto(userFound);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    boolean existEmail(String email){
        return userRepository.findByEmail(email).isPresent();
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()->new EntityNotFoundException("User not found email:"+email));
    }

    public void enableUser(User user){
        user.setEnable(true);
        userRepository.save(user);
    }

    public String register(UserDto dto) {
        boolean existEmail = existEmail(dto.getEmail());
        if (existEmail) {
            throw new EmailTaken(dto.getEmail());
        }

        User user = userMapper.toUser(dto);
        user.setRole(roleService.getByName("USER"));

        String endedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(endedPassword);

        create(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.create(confirmationToken);


        String confirmLink = UriGenerator.create("/users/confirm", "token", token);
        String bodyHtml = HtmlGenerator.generateConfirmationTemplate(user.getFirstName(), confirmLink);

        EmailNotificationDto emailNotification = EmailNotificationDto.builder()
                .hasTemplate(true)
                .to(user.getEmail())
                .subject("Confirmation Account")
                .body(bodyHtml)
                .build();

        emailService.send(emailNotification);
        return token;
    }


    public String confirm(String token){
        ConfirmationToken confirm = confirmationTokenService.getByToken(token);
        //verificamos si el token NO ha sido confirmado
        if(confirm.getConfirmedAt()!=null){
            throw new RuntimeException("Token is already confirmed");
        }
        //Validamos que el token no haya expirado
        if(confirm.getExpiresAt().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Token expired");
        }
        //Habilitamos al usuario y setear fecha de confirmacion
        enableUser(confirm.getUser());
        confirmationTokenService.setConfirmeAt(confirm);
        return "User account has been enabled successfully";
    }

}
