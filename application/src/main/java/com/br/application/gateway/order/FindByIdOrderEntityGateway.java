package com.br.application.gateway.order;

import com.br.core.entities.OrderEntity;

import java.util.UUID;

public interface FindByIdOrderEntityGateway {
    OrderEntity findById(UUID id);
}
