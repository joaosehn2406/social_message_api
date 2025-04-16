package com.jceco.redesocial_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jceco.redesocial_api.entities.Comment;


public interface CommentRepository extends JpaRepository<Comment, String>{

}
