package com.br.infrastructure.dto.user;

import com.br.core.enums.Roles;

public record UserResponseDTO(String login, String password, Roles roles) {
}
