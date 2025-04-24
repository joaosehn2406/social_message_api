package com.jceco.redesocial_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jceco.redesocial_api.dto.UserDTO;
import com.jceco.redesocial_api.services.impl.UserServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/users")
@Tag(name = "Usuário", description = "Endpoints para gerenciar usuários dos posts")
public class UserController {
	
	@Autowired
	private UserServiceImpl service;

	public UserController(UserServiceImpl service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Listar todos os usuários")
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> usu = service.findAll();
		
		return ResponseEntity.ok(usu);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Buscar usuário por ID")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		UserDTO usu = service.findById(id);
		
		return ResponseEntity.ok().body(usu);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Inserir usuários", description = "Insere usuários através de JSON")
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto) {
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/api/users").buildAndExpand(dto.id()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Atualizar totalmente usuários", description = "Atualiza totalmente um usuário existente com base no ID referenciado")
	public ResponseEntity<UserDTO> put(@RequestBody UserDTO dto, @PathVariable Long id) {
		UserDTO DTO = service.update(id, dto);
		
		return ResponseEntity.ok().body(DTO);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(summary = "Atualiza parcialmente usuários", description = "Atualiza parcialmente um usuário existente com base no ID referenciado")
	public ResponseEntity<UserDTO> patch(@RequestBody UserDTO dto, @PathVariable Long id) {
		UserDTO DTO = service.patch(id, dto);
		
		return ResponseEntity.ok().body(DTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Deletar usuário", description = "Delte o usuário com base no ID referenciado")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
