package com.jceco.redesocial_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jceco.redesocial_api.DTO.UserDTO;
import com.jceco.redesocial_api.service.impl.UserServiceImpl;



@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServiceImpl service;

	public UserController(UserServiceImpl service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getdAll() {
		List<UserDTO> entity = service.findAll();
		
		return ResponseEntity.ok(entity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		UserDTO user = service.findById(id);
		
		return ResponseEntity.ok(user);
		
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO user) {
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.id()).toUri();
		
		return ResponseEntity.created(uri).body(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO user, @PathVariable Long id) {
		user = service.update(id, user);
		
		return ResponseEntity.ok().body(user);
	}
	
	
	@PatchMapping("/{id}")
	public ResponseEntity<UserDTO> patch(@RequestBody UserDTO user, @PathVariable Long id) {
		user = service.patch(id, user);
		
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delte(@PathVariable Long id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
