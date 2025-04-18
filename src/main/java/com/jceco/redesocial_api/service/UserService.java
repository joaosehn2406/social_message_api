package com.jceco.redesocial_api.service;

import java.util.List;

import com.jceco.redesocial_api.DTO.PostDTO;
import com.jceco.redesocial_api.DTO.UserDTO;


public interface UserService {
	
	List<UserDTO> findAll();
	UserDTO findById(Long id);
	UserDTO insert(UserDTO author, PostDTO posts);
	UserDTO update(Long id, UserDTO author);
	UserDTO patch(Long id, UserDTO author);
	void delete(Long id);
}
