package com.jceco.redesocial_api.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	private Long id;
	private String name;
	private String email;
	
	@OneToMany(mappedBy = "author")
	private Set<Post> posts;
	
	public User() {}

	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

	public User(Long id, String name, String email, Set<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.posts = posts;
	}
	
	

	public Set<Post> getPosts() {
		return posts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	};
	
	
}
