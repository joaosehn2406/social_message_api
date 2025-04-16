package com.jceco.redesocial_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jceco.redesocial_api.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
