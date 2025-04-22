package com.jceco.redesocial_api.services.impl;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.jceco.redesocial_api.dto.CommentDTO;
import com.jceco.redesocial_api.dto.PostDTO;
import com.jceco.redesocial_api.dto.UserSummaryDTO;
import com.jceco.redesocial_api.entities.Comment;
import com.jceco.redesocial_api.entities.Post;
import com.jceco.redesocial_api.entities.User;
import com.jceco.redesocial_api.repository.CommentRepository;
import com.jceco.redesocial_api.repository.PostRepository;
import com.jceco.redesocial_api.repository.UserRepository;
import com.jceco.redesocial_api.services.CommentService;

import jakarta.persistence.EntityNotFoundException;

public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	

	public CommentServiceImpl(CommentRepository repository, UserRepository userRepository,
			PostRepository postRepository) {
		super();
		this.repository = repository;
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@Override
	public List<CommentDTO> findAll() {
		return repository.findAll().stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public CommentDTO findById(Long id) {
		return repository.findAll().stream()
				.filter(x -> x.getId().equals(id))
				.findFirst()
				.map(this::toDTO)
				.orElseThrow();
	}

	@Override
	public CommentDTO insert(CommentDTO dto) {
		User user = userRepository.findById(dto.author().id())
			    .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));

		Post post = postRepository.findById(dto.post().id())
			    .orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));

		
		Comment comment = new Comment();
		comment.setText(dto.text());
		comment.setDate(dto.date() != null ? dto.date() : Instant.now());
		comment.setAuthor(user);
		comment.setPost(post);
		
		comment = repository.save(comment);
		
		return toDTO(comment);
	}

	@Override
	public CommentDTO update(Long id, CommentDTO dto) {
		User user = userRepository.findById(dto.author().id())
			    .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));

		Post post = postRepository.findById(dto.post().id())
			    .orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));
		
		Comment comment = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado"));
		
		comment.setText(dto.text());
		comment.setDate(dto.date());
		comment.setAuthor(user);
		comment.setPost(post);
		
		comment = repository.save(comment);
		
		return toDTO(comment);
	}

	@Override
	public CommentDTO patch(Long id, CommentDTO dto) {
		Comment comment = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));
		
		if (comment.getText() != null) {
			comment.setText(dto.text());
		}
		
		if (comment.getDate() != null) {
			comment.setDate(dto.date());
			
		}
		
		if (comment.getAuthor() != null) {
			User u = userRepository.findById(dto.author().id())
					.orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));
			comment.setAuthor(u);
					
		}
		
		if (comment.getPost() != null) {
			Post p = postRepository.findById(dto.post().id())
					.orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));
			comment.setPost(p);
		}
		
		comment = repository.save(comment);
		
		return toDTO(comment);
	}

	@Override
	public void delete(Long id) {
		Comment comment = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));
		
		repository.delete(comment);
		
	}
	
	private CommentDTO toDTO(Comment comment) {
	    
	    UserSummaryDTO authorDTO = new UserSummaryDTO(
	        comment.getAuthor().getId(),
	        comment.getAuthor().getName()
	    );


	    User postAuthor = comment.getPost().getAuthor();
	    UserSummaryDTO postAuthorDTO = new UserSummaryDTO(
	        postAuthor.getId(),
	        postAuthor.getName()
	    );


	    Post post = comment.getPost();
	    PostDTO postDTO = new PostDTO(
	        post.getId(),
	        post.getDate(),
	        post.getTitle(),
	        post.getBody(),
	        postAuthorDTO,
	        null 
	    );

	    return new CommentDTO(
	        comment.getText(),
	        comment.getDate(),
	        authorDTO,
	        postDTO
	    );
	}



}
