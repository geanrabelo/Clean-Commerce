package com.br.usecases.product;

import com.br.core.entities.ProductEntity;
import com.br.core.exceptions.ProductNotFound;

public interface FindByIdProductEntityUseCase {
    ProductEntity findById(Long id) throws ProductNotFound;
}
