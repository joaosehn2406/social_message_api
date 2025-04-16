package com.jceco.redesocial_api.DTO;

import java.time.Instant;
import java.util.List;

import com.jceco.redesocial_api.entities.Comment;
import com.jceco.redesocial_api.entities.User;;

public record PostDTO(Long id, String title, String body, Instant date, List<Comment> comments, User user) {

}
