package com.br.application.impl.product;

import com.br.application.gateway.product.FindByIdProductEntityGateway;
import com.br.core.entities.ProductEntity;
import com.br.usecases.product.FindByIdProductEntityUseCase;

public class FindByIdProductEntityUseCaseImpl implements FindByIdProductEntityUseCase {

    private FindByIdProductEntityGateway findByIdProductEntityGateway;

    public FindByIdProductEntityUseCaseImpl(FindByIdProductEntityGateway findByIdProductEntityGateway){
        this.findByIdProductEntityGateway = findByIdProductEntityGateway;
    }
    @Override
    public ProductEntity findById(Long id) {
        return findByIdProductEntityGateway.findById(id);
    }
}
