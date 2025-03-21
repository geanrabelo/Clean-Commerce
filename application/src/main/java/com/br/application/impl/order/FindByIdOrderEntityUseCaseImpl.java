package com.br.application.impl.order;

import com.br.application.gateway.order.ExistsByIdOrderEntityGateway;
import com.br.application.gateway.order.FindByIdOrderEntityGateway;
import com.br.core.entities.OrderEntity;
import com.br.core.exceptions.OrderNotFound;
import com.br.usecases.order.FindByIdOrderEntityUseCase;

import java.util.UUID;

public class FindByIdOrderEntityUseCaseImpl implements FindByIdOrderEntityUseCase {

    private FindByIdOrderEntityGateway findByIdOrderEntityGateway;
    private ExistsByIdOrderEntityGateway existsByIdOrderEntityGateway;

    public FindByIdOrderEntityUseCaseImpl(FindByIdOrderEntityGateway findByIdOrderEntityGateway,
                                          ExistsByIdOrderEntityGateway existsByIdOrderEntityGateway){
        this.findByIdOrderEntityGateway = findByIdOrderEntityGateway;
        this.existsByIdOrderEntityGateway = existsByIdOrderEntityGateway;
    }
    @Override
    public OrderEntity findById(UUID id) throws OrderNotFound {
        if(!existsByIdOrderEntityGateway.existsById(id)){
            throw new OrderNotFound("Order searched by id not found!");
        }
        return findByIdOrderEntityGateway.findById(id);
    }
}
