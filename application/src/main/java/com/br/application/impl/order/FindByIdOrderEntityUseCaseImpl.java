package com.br.application.impl.order;

import com.br.application.gateway.order.FindByIdOrderEntityGateway;
import com.br.core.entities.OrderEntity;
import com.br.usecases.order.FindByIdOrderEntityUseCase;

import java.util.UUID;

public class FindByIdOrderEntityUseCaseImpl implements FindByIdOrderEntityUseCase {

    private FindByIdOrderEntityGateway findByIdOrderEntityGateway;

    public FindByIdOrderEntityUseCaseImpl(FindByIdOrderEntityGateway findByIdOrderEntityGateway){
        this.findByIdOrderEntityGateway = findByIdOrderEntityGateway;
    }
    @Override
    public OrderEntity findById(UUID id) {
        return findByIdOrderEntityGateway.findById(id);
    }
}
