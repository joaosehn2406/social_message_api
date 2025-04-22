package com.jceco.redesocial_api.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

<<<<<<< HEAD
@Entity
@Table(name = "tb_user")
public class User {
=======
import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private Set<Post> posts;
	
	public User() {}
>>>>>>> c6d54c9ce2115a40b6fae4ace9780355586679e0

    @Id
    private Long id;

<<<<<<< HEAD
    private String name;
    private String email;
=======
	public User(Long id, String name, String email, Set<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.posts = posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
>>>>>>> c6d54c9ce2115a40b6fae4ace9780355586679e0

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    public User() {}

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

<<<<<<< HEAD
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
=======
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




>>>>>>> c6d54c9ce2115a40b6fae4ace9780355586679e0
}
