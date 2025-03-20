package com.br.application.impl.order;

import com.br.application.gateway.order.CreateOrderEntityGateway;
import com.br.core.entities.ProductEntity;
import com.br.core.entities.UserEntity;
import com.br.usecases.order.CreateOrderEntityUseCase;

import java.util.List;

public class CreateOrderEntityUseCaseImpl implements CreateOrderEntityUseCase {


    private CreateOrderEntityGateway createOrderEntityGateway;

    public CreateOrderEntityUseCaseImpl(CreateOrderEntityGateway createOrderEntityGateway){
        this.createOrderEntityGateway = createOrderEntityGateway;
    }

    @Override
    public void create(UserEntity user, float price) {
        createOrderEntityGateway.create(user, price);
    }
}
