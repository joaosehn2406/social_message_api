package com.jceco.redesocial_api.dto;

import java.time.Instant;
import java.util.List;

public record PostDTO(
    Long id,
    Instant date,
    String title,
    String body,
    UserSummaryDTO author,
    List<CommentDTO> comments
) {}

