package com.br.application.impl.order;

import com.br.application.gateway.order.DeleteByIdOrderEntityGateway;
import com.br.usecases.order.DeleteByIdOrderEntityUseCase;

import java.util.UUID;

public class DeleteByIdOrderEntityUseCaseImpl implements DeleteByIdOrderEntityUseCase {

    private DeleteByIdOrderEntityGateway deleteByIdOrderEntityGateway;
    private DeleteByIdOrderEntityUseCaseImpl(DeleteByIdOrderEntityGateway deleteByIdOrderEntityGateway){
        this.deleteByIdOrderEntityGateway = deleteByIdOrderEntityGateway;
    }
    @Override
    public void deleteById(UUID id) {
        deleteByIdOrderEntityGateway.deleteById(id);
    }
}
