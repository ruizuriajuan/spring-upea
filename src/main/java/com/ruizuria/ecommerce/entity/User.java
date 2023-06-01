package com.ruizuria.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
    private String address;
    private Boolean enable;

    @ManyToOne
    @JoinColumn(name="id_role")
    private Role role;
}
