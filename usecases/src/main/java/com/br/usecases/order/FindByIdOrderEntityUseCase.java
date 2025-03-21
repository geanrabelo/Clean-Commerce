package com.br.usecases.order;

import com.br.core.entities.OrderEntity;
import com.br.core.exceptions.OrderNotFound;

import java.util.UUID;

public interface FindByIdOrderEntityUseCase {
    OrderEntity findById(UUID id) throws OrderNotFound;
}
