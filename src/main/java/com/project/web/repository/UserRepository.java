package com.project.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.web.entitys.User;

public interface UserRepository extends JpaRepository <User, Long> {
     
    public Optional<User> findByEmail(String email);
    public Optional<User> findByUserNameOrEmail(String username, String email);

    public Optional<User> findByUserName(String username);

    public Boolean existsByUserName(String username);

    public Boolean existsByEmail(String email); 
}
