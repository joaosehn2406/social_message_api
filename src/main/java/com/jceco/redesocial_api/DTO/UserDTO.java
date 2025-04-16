package com.jceco.redesocial_api.DTO;

import java.util.Set;

import com.jceco.redesocial_api.entities.Post;

public record UserDTO (String id, String name, String email, Set<Post> posts) {
	
}
