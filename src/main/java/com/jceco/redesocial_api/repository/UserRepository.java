package com.jceco.redesocial_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jceco.redesocial_api.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
