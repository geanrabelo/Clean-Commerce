package com.br.usecases.product;

import com.br.core.entities.OrderEntity;
import com.br.core.entities.ProductEntity;

import java.util.UUID;

public interface CreateProductEntityUseCase {
    void create(ProductEntity product);
}
