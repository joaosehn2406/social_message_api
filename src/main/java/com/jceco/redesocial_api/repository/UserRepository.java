package com.jceco.redesocial_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jceco.redesocial_api.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
