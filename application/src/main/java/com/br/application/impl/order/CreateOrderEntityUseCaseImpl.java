package com.br.application.impl.order;

import com.br.application.gateway.order.CreateOrderEntityGateway;
import com.br.core.entities.ProductEntity;
import com.br.core.entities.UserEntity;
import com.br.usecases.order.CreateOrderEntityUseCase;

import java.util.List;
import java.util.UUID;

public class CreateOrderEntityUseCaseImpl implements CreateOrderEntityUseCase {


    private CreateOrderEntityGateway createOrderEntityGateway;

    public CreateOrderEntityUseCaseImpl(CreateOrderEntityGateway createOrderEntityGateway){
        this.createOrderEntityGateway = createOrderEntityGateway;
    }

    @Override
    public UUID create(UserEntity user) {
        return createOrderEntityGateway.create(user);
    }
}
