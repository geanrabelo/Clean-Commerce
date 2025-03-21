package com.br.application.impl.order;

import com.br.application.gateway.order.ExistsByIdOrderEntityGateway;
import com.br.usecases.order.ExistsByIdOrderEntityUseCase;

import java.util.UUID;

public class ExistsByIdOrderEntityUseCaseImpl implements ExistsByIdOrderEntityUseCase {

    private ExistsByIdOrderEntityGateway existsByIdOrderEntityGateway;

    public ExistsByIdOrderEntityUseCaseImpl(ExistsByIdOrderEntityGateway existsByIdOrderEntityGateway){
        this.existsByIdOrderEntityGateway = existsByIdOrderEntityGateway;
    }

    @Override
    public boolean existsById(UUID id) {
        return existsByIdOrderEntityGateway.existsById(id);
    }
}
