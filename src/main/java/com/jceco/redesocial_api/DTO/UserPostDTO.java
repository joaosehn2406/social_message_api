package com.jceco.redesocial_api.DTO;

public class UserPostDTO {
    private UserDTO user;
    private PostDTO post;


    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }
}
