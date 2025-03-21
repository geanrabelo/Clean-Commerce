package com.br.application.gateway.product;

import com.br.core.entities.OrderEntity;
import com.br.core.entities.ProductEntity;

import java.util.UUID;

public interface CreateProductEntityGateway {
    void create(ProductEntity product);
}
