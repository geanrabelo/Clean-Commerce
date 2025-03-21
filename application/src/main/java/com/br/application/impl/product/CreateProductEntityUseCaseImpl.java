package com.br.application.impl.product;

import com.br.application.gateway.product.CreateProductEntityGateway;
import com.br.core.entities.OrderEntity;
import com.br.core.entities.ProductEntity;
import com.br.core.enums.Roles;
import com.br.usecases.product.CreateProductEntityUseCase;

import java.util.UUID;

public class CreateProductEntityUseCaseImpl implements CreateProductEntityUseCase {

    private CreateProductEntityGateway createProductEntityGateway;

    public CreateProductEntityUseCaseImpl(CreateProductEntityGateway createProductEntityGateway){
        this.createProductEntityGateway = createProductEntityGateway;
    }
    @Override
    public void create(ProductEntity product) {
        createProductEntityGateway.create(product);
    }
}
