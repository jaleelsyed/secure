package com.syed.securityjwt.dao.repo;

import com.syed.securityjwt.dao.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Users findByEmail(String email);

    List<Users> findAll();
}
