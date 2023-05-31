package com.ruizuria.ecommerce.repository;

import com.ruizuria.ecommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
    Optional<Role>  findRoleByName(String name);

    @Query(value = "SELECT r FROM Role r WHERE r.name = ?1")
    Optional<Role>  getByName(String name);

    Optional<Role> findByName(String name);
}
