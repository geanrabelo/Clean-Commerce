package com.br.application.gateway.product;

import com.br.core.entities.OrderEntity;

import java.util.UUID;

public interface CreateProductEntityGateway {
    void create(String name, int quantity, float price, UUID order_uuid);
}
