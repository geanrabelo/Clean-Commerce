package com.br.infrastructure.dto.user;

import com.br.core.enums.Roles;

public record RegisterDTO(String login, String password, Roles roles) {
}
