package com.jceco.redesocial_api.dto;

import java.util.Set;

<<<<<<< HEAD
public record UserDTO(
    Long id,
    String name,
    String email
) {}
=======
public record UserDTO(Long id, String name, String email, Set<Long> postIds) {
}
>>>>>>> c6d54c9ce2115a40b6fae4ace9780355586679e0
