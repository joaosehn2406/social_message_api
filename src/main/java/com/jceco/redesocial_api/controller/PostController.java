package com.jceco.redesocial_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jceco.redesocial_api.dto.PostDTO;
import com.jceco.redesocial_api.services.impl.PostServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "Post", description = "Endpoints para gerenciamento de posts")
public class PostController {

    @Autowired
    private PostServiceImpl service;

    public PostController(PostServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos os posts")
    @ApiResponse(responseCode = "200", description = "Posts listados com sucesso")
    public ResponseEntity<List<PostDTO>> findAll() {
        List<PostDTO> postDTO = service.findAll();
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar post por ID")
    @ApiResponse(responseCode = "200", description = "Post encontrado")
    public ResponseEntity<PostDTO> findById(@PathVariable Long id) {
        PostDTO post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    @Operation(summary = "Criar novo post")
    @ApiResponse(responseCode = "201", description = "Post criado com sucesso")
    public ResponseEntity<PostDTO> insert(@RequestBody PostDTO post) {
        post = service.insert(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(post.id()).toUri();
        return ResponseEntity.created(uri).body(post);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar post por ID (substituição completa)")
    @ApiResponse(responseCode = "200", description = "Post atualizado com sucesso")
    public ResponseEntity<PostDTO> update(@PathVariable Long id, @RequestBody PostDTO post) {
        post = service.update(id, post);
        return ResponseEntity.ok(post);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar parcialmente um post por ID")
    @ApiResponse(responseCode = "200", description = "Post parcialmente atualizado com sucesso")
    public ResponseEntity<PostDTO> patch(@PathVariable Long id, @RequestBody PostDTO post) {
        post = service.patch(id, post);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover post por ID")
    @ApiResponse(responseCode = "204", description = "Post deletado com sucesso")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
