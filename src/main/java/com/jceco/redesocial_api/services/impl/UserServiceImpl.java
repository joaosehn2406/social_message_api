package com.jceco.redesocial_api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jceco.redesocial_api.dto.UserDTO;
import com.jceco.redesocial_api.entities.User;
import com.jceco.redesocial_api.repository.UserRepository;
import com.jceco.redesocial_api.services.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	
	
	public UserServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<UserDTO> findAll() {
		return repository.findAll().stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public UserDTO findById(Long id) {
		return repository.findAll().stream()
				.filter(x -> x.getId().equals(id))
				.findFirst()
				.map(this::toDTO)
				.orElseThrow();
	}

	@Override
	public UserDTO insert(UserDTO dto) {
		User user = new User();
		
		user.setEmail(dto.email());
		user.setName(dto.name());
		
		user = repository.save(user);
		
		return toDTO(user);
	}

	@Override
	public UserDTO update(Long id, UserDTO dto) {
		User user = repository.findById(id)
				.orElseThrow();
		
		user.setEmail(dto.email());
		user.setName(dto.name());
		
		user = repository.save(user);
		
		return toDTO(user);
	}

	@Override
	public UserDTO patch(Long id, UserDTO dto) {
		User user = repository.findById(id)
				.orElseThrow();
		
		if (dto.name() != null) {
			user.setName(dto.name());
		}
		
		if (dto.email() != null) {
			user.setEmail(dto.email());
		}
		
		user = repository.save(user);
		
		return toDTO(user);
	}

	@Override
	public void delete(Long id) {
	    User user = repository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

	    repository.delete(user);
	}

	
	private UserDTO toDTO(User user) {
		return new UserDTO(user.getId(), user.getName(), user.getEmail());
	}

}
