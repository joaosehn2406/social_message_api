package com.jceco.redesocial_api.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.jceco.redesocial_api.DTO.PostDTO;
import com.jceco.redesocial_api.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jceco.redesocial_api.DTO.UserDTO;
import com.jceco.redesocial_api.entities.User;
import com.jceco.redesocial_api.repository.UserRepository;
import com.jceco.redesocial_api.service.UserService;

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
				.orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public UserDTO insert(UserDTO author, PostDTO posts) {
		User entity = new User();
		
		entity.setId(author.id());
		entity.setEmail(author.email());
		entity.setName(author.name());


		Post post = new Post();

		post.setId(posts.id());
		post.setBody(posts.body());
		post.setTitle(posts.title());
		post.setDate(posts.date());
		post.setAuthor(entity);

		entity.getPosts().add(post);

		entity = repository.save(entity);
		
		return toDTO(entity);
	}

	@Override
	public UserDTO update(Long id, UserDTO author) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		entity.setEmail(author.email());
		entity.setName(author.name());
		
		entity = repository.save(entity);
		
		return toDTO(entity);
	}

	@Override
	public UserDTO patch(Long id, UserDTO author) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		
		if (author.email() != null) {
			entity.setEmail(author.email());
		}
		
		if(author.name() != null) {
			entity.setName(author.name());
		}
		
		entity = repository.save(entity);
		
		return toDTO(entity);

	}

	@Override
	public void delete(Long id) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		repository.delete(entity);
		
	}

	private UserDTO toDTO(User user) {
		Set<Long> postIds = user.getPosts().stream()
				.map(Post::getId)
				.collect(Collectors.toSet());
		return new UserDTO(user.getId(), user.getName(), user.getEmail(), postIds);
	}



}
