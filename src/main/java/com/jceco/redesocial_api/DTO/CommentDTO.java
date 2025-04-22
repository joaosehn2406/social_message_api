package com.jceco.redesocial_api.dto;

import java.time.Instant;

public record CommentDTO(
    String text,
    Instant date,
    UserSummaryDTO author,
    PostDTO post
) {}

