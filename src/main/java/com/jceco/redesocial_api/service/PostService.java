package com.jceco.redesocial_api.service;

import com.jceco.redesocial_api.DTO.CommentDTO;
import com.jceco.redesocial_api.DTO.PostDTO;


import java.util.List;

public interface PostService {

    List<PostDTO> findAll();
    PostDTO findById(Long id);
    PostDTO insert(PostDTO post, CommentDTO comment);
    void delete();
}
