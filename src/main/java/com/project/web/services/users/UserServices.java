package com.project.web.services.users;

import java.util.List;

import com.project.web.dtos.otherFuntionality.RegisterDTO;

public interface UserServices {
    public RegisterDTO createUser(RegisterDTO registerDTO);

    public List<RegisterDTO> getAll();

    public RegisterDTO findByUserId(Long id);

    public RegisterDTO updateUser(RegisterDTO registerDTO, Long id);

    public void deleteUser(Long id);
}