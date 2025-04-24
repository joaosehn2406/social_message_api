package com.jceco.redesocial_api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jceco.redesocial_api.dto.CommentDTO;
import com.jceco.redesocial_api.services.impl.CommentServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/comments")
@Tag(name = "Comentário", description = "Endpoints para gerenciamento de comentários")
public class CommentController {

    @Autowired
    private CommentServiceImpl service;

    public CommentController(CommentServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos os comentários")
    @ApiResponse(responseCode = "200", description = "Comentários listados com sucesso")
    public ResponseEntity<List<CommentDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar comentário por ID")
    @ApiResponse(responseCode = "200", description = "Comentário encontrado")
    public ResponseEntity<CommentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Inserir novo comentário")
    @ApiResponse(responseCode = "201", description = "Comentário criado com sucesso")
    public ResponseEntity<CommentDTO> insert(@RequestBody CommentDTO dto) {
        CommentDTO saved = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.post().id()).toUri();
        return ResponseEntity.created(uri).body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um comentário (substituição completa)")
    @ApiResponse(responseCode = "200", description = "Comentário atualizado com sucesso")
    public ResponseEntity<CommentDTO> update(@PathVariable Long id, @RequestBody CommentDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar parcialmente um comentário")
    @ApiResponse(responseCode = "200", description = "Comentário parcialmente atualizado com sucesso")
    public ResponseEntity<CommentDTO> patch(@PathVariable Long id, @RequestBody CommentDTO dto) {
        return ResponseEntity.ok(service.patch(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover comentário")
    @ApiResponse(responseCode = "204", description = "Comentário removido com sucesso")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
