package com.jceco.redesocial_api.services;

import java.util.List;

import com.jceco.redesocial_api.dto.CommentDTO;



public interface CommentService {

    List<CommentDTO> findAll();

    CommentDTO findById(Long id);

    CommentDTO insert(CommentDTO dto);

    CommentDTO update(Long id, CommentDTO dto);

    CommentDTO patch(Long id, CommentDTO dto);

    void delete(Long id);
}
