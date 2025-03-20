package com.br.application.gateway.product;

import com.br.core.entities.ProductEntity;

public interface FindByIdProductEntityGateway {
    ProductEntity findById(Long id);
}
