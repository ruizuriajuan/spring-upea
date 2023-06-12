package com.ruizuria.ecommerce.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    @Pattern(regexp = "(.+?)@(.+?)")
    private String email;
    private String address;
    private String password;
    private Boolean enable;
    private String role;
}




