package com.jceco.redesocial_api.DTO;

public class PostCommentDTO {

    private PostDTO postDTO;
    private CommentDTO commentDTO;

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public CommentDTO getCommentDTO() {
        return commentDTO;
    }

    public void setCommentDTO(CommentDTO commentDTO) {
        this.commentDTO = commentDTO;
    }
}
