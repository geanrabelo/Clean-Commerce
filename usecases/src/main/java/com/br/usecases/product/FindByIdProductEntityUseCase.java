package com.br.usecases.product;

import com.br.core.entities.ProductEntity;

public interface FindByIdProductEntityUseCase {
    ProductEntity findById(Long id);
}
