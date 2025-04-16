package com.jceco.redesocial_api.DTO;

import java.time.Instant;

import com.jceco.redesocial_api.entities.Post;
import com.jceco.redesocial_api.entities.User;

public record CommentDTO(String id, String text, Instant date, Post post, User author) {

}
