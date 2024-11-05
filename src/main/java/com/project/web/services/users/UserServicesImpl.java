package com.project.web.services.users;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.web.dtos.otherFuntionality.RegisterDTO;
import com.project.web.entitys.Rol;
import com.project.web.entitys.User;
import com.project.web.repository.RolRepository;
import com.project.web.repository.UserRepository;
@Service
public class UserServicesImpl implements UserServices {

    @Autowired
 private  UserRepository userRepository;
 @Autowired
 private RolRepository rolRepository;
 @Autowired
 private PasswordEncoder passwordEncoder;
 @Autowired
 private ModelMapper modelMapper;
    @Override
    public RegisterDTO createUser(RegisterDTO registerDTO) {
      
        User user = mapearEntity(registerDTO);
 
 user.setEmail(registerDTO.getEmail());
 user.setUserImage(registerDTO.getUserImage());
 user.setPhoneNumber(registerDTO.getPhoneNumber());
 user.setUserName(registerDTO.getUserName());
 user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
 user.setSeller(registerDTO.isSeller());

 Rol roles = rolRepository.findByName("ROLE_USER").get();
 user.setRoles(Collections.singleton(roles));
User newUser = userRepository.save(user); 
 
 return mapearDTO(newUser);
    }

    @Override
    public List<RegisterDTO> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public RegisterDTO findByUserId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUserId'");
    }

    @Override
    public RegisterDTO updateUser(RegisterDTO registerDTO, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
     private RegisterDTO mapearDTO(User user) {
        return modelMapper.map(user, RegisterDTO.class);
     }
     private User mapearEntity(RegisterDTO registerDTO){
        return modelMapper.map(registerDTO, User.class);
     }
}
