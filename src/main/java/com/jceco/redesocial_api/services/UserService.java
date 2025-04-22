package com.jceco.redesocial_api.services;

import java.util.List;

import com.jceco.redesocial_api.dto.UserDTO;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO insert(UserDTO dto);

    UserDTO update(Long id, UserDTO dto);

    UserDTO patch(Long id, UserDTO dto); 

    void delete(Long id);
}
