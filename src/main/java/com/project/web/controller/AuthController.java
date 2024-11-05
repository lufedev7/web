package com.project.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.web.dtos.otherFuntionality.LoginDTO;
import com.project.web.dtos.otherFuntionality.RegisterDTO;

import com.project.web.repository.UserRepository;
import com.project.web.services.users.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
   @Autowired
   private AuthenticationManager authenticationManager;
   @Autowired
   private UserRepository userRepository;
   
   @Autowired
   private UserServices userServices;

   @PostMapping("/login")
   public ResponseEntity<String> authenticationUser(@RequestBody LoginDTO loginDTO) {
      Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(authentication);
      return new ResponseEntity<>("Init sucessfully!!!", HttpStatus.OK);
   }

   @PostMapping("/register")
   public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
      if (userRepository.existsByUserName(registerDTO.getUserName())) {
         return new ResponseEntity<>("this username already exist", HttpStatus.BAD_REQUEST);
      }
      if (userRepository.existsByEmail(registerDTO.getEmail())) {
         return new ResponseEntity<>("This email already exist", HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity<>(userServices.createUser(registerDTO), HttpStatus.CREATED);
   }
}
