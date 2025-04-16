package com.jceco.redesocial_api.service;

import java.util.List;

import com.jceco.redesocial_api.DTO.UserDTO;


public interface UserService {
	
	List<UserDTO> findAll();
	UserDTO findById(String id);
	UserDTO insert(UserDTO author);
	UserDTO update(String id, UserDTO author);
	UserDTO patch(String id, UserDTO author);
	void delete(String id);
}
