package com.jceco.redesocial_api.services;

import java.util.List;

import com.jceco.redesocial_api.dto.PostDTO;

public interface PostService {

    List<PostDTO> findAll();

    PostDTO findById(Long id);

    PostDTO insert(PostDTO dto);

    PostDTO update(Long id, PostDTO dto);

    PostDTO patch(Long id, PostDTO dto);

    void delete(Long id);
}
