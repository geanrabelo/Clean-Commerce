package com.br.infrastructure.dto.user;

import com.br.core.enums.Roles;

public record AuthenticationDTO(String login, String password) {
}
