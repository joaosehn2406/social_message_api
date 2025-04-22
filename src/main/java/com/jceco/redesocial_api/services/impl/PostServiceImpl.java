package com.jceco.redesocial_api.services.impl;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jceco.redesocial_api.dto.CommentDTO;
import com.jceco.redesocial_api.dto.PostDTO;
import com.jceco.redesocial_api.dto.UserSummaryDTO;
import com.jceco.redesocial_api.entities.Comment;
import com.jceco.redesocial_api.entities.Post;
import com.jceco.redesocial_api.entities.User;
import com.jceco.redesocial_api.repository.PostRepository;
import com.jceco.redesocial_api.repository.UserRepository;
import com.jceco.redesocial_api.services.PostService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PostDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO findById(Long id) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));
        return toDTO(post);
    }

    @Override
    public PostDTO insert(PostDTO dto) {
        User user = userRepository.findById(dto.author().id())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));

        Post post = new Post();
        post.setTitle(dto.title());
        post.setBody(dto.body());
        post.setDate(dto.date() != null ? dto.date() : Instant.now());
        post.setAuthor(user);

        post = repository.save(post);
        return toDTO(post);
    }

    @Override
    public PostDTO update(Long id, PostDTO dto) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));

        User user = userRepository.findById(dto.author().id())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));

        post.setTitle(dto.title());
        post.setBody(dto.body());
        post.setDate(dto.date());
        post.setAuthor(user);

        post = repository.save(post);
        return toDTO(post);
    }

    @Override
    public PostDTO patch(Long id, PostDTO dto) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));

        if (dto.title() != null) {
            post.setTitle(dto.title());
        }

        if (dto.body() != null) {
            post.setBody(dto.body());
        }

        if (dto.date() != null) {
            post.setDate(dto.date());
        }

        if (dto.author() != null && dto.author().id() != null) {
            User user = userRepository.findById(dto.author().id())
                    .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));
            post.setAuthor(user);
        }

        post = repository.save(post);
        return toDTO(post);
    }

    @Override
    public void delete(Long id) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));
        repository.delete(post);
    }

    private PostDTO toDTO(Post post) {
        UserSummaryDTO authorDTO = new UserSummaryDTO(
            post.getAuthor().getId(),
            post.getAuthor().getName()
        );


        PostDTO simplifiedPostDTO = new PostDTO(
            post.getId(),
            post.getDate(),
            post.getTitle(),
            post.getBody(),
            authorDTO,
            null
        );

        List<CommentDTO> commentDTOs = post.getComments().stream()
            .map(comment -> toCommentDTO(comment, simplifiedPostDTO))
            .collect(Collectors.toList());

        return new PostDTO(
            post.getId(),
            post.getDate(),
            post.getTitle(),
            post.getBody(),
            authorDTO,
            commentDTOs
        );
    }

    private CommentDTO toCommentDTO(Comment comment, PostDTO postDTO) {
        UserSummaryDTO authorDTO = new UserSummaryDTO(
            comment.getAuthor().getId(),
            comment.getAuthor().getName()
        );

        return new CommentDTO(
            comment.getText(),
            comment.getDate(),
            authorDTO,
            postDTO
        );
    }
}

