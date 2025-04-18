package com.jceco.redesocial_api.DTO;

import java.util.Set;

public record UserDTO(Long id, String name, String email, Set<Long> postIds) {
}
