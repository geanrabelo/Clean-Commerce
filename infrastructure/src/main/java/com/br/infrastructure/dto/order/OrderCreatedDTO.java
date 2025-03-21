package com.br.infrastructure.dto.order;

import com.br.infrastructure.domain.User;

import java.util.UUID;

public record OrderCreatedDTO(UUID uuid, User user) {
}
