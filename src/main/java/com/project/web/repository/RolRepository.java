package com.project.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.web.entitys.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{ 
     public Optional<Rol> findByName(String name);
}
