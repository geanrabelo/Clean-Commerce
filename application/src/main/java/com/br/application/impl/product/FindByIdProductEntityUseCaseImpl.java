package com.br.application.impl.product;

import com.br.application.gateway.product.ExistsByIdProductEntityGateway;
import com.br.application.gateway.product.FindByIdProductEntityGateway;
import com.br.core.entities.ProductEntity;
import com.br.core.exceptions.ProductNotFound;
import com.br.usecases.product.FindByIdProductEntityUseCase;

public class FindByIdProductEntityUseCaseImpl implements FindByIdProductEntityUseCase {

    private FindByIdProductEntityGateway findByIdProductEntityGateway;
    private ExistsByIdProductEntityGateway existsByIdProductEntityGateway;

    public FindByIdProductEntityUseCaseImpl(FindByIdProductEntityGateway findByIdProductEntityGateway, ExistsByIdProductEntityGateway existsByIdProductEntityGateway){
        this.findByIdProductEntityGateway = findByIdProductEntityGateway;
        this.existsByIdProductEntityGateway = existsByIdProductEntityGateway;
    }

    @Override
    public ProductEntity findById(Long id) throws ProductNotFound {
        if(!existsByIdProductEntityGateway.existsById(id)) {
            throw new ProductNotFound("Product searched by id not found!");
        }
        return findByIdProductEntityGateway.findById(id);
    }
}
