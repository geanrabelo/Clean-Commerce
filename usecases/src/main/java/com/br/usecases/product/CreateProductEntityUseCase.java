package com.br.usecases.product;

import com.br.core.entities.OrderEntity;

import java.util.UUID;

public interface CreateProductEntityUseCase {
    void create(String name, int quantity, float price, UUID order_uuid);
}
