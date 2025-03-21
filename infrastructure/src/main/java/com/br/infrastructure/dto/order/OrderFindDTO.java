package com.br.infrastructure.dto.order;

import com.br.infrastructure.domain.User;

import java.util.UUID;

public record OrderFindDTO(UUID uuid, User user, float price) {
}
