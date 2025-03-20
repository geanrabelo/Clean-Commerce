package com.br.usecases.order;

import com.br.core.entities.OrderEntity;

import java.util.UUID;

public interface FindByIdOrderEntityUseCase {
    OrderEntity findById(UUID id);
}
