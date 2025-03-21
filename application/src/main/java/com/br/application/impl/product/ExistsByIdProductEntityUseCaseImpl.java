package com.br.application.impl.product;

import com.br.application.gateway.product.ExistsByIdProductEntityGateway;
import com.br.usecases.product.ExistsByIdProductEntityUseCase;

public class ExistsByIdProductEntityUseCaseImpl implements ExistsByIdProductEntityUseCase {

    private ExistsByIdProductEntityGateway existsByIdProductEntityGateway;

    public ExistsByIdProductEntityUseCaseImpl(ExistsByIdProductEntityGateway existsByIdProductEntityGateway){
        this.existsByIdProductEntityGateway = existsByIdProductEntityGateway;
    }
    @Override
    public boolean existsById(Long id) {
        return existsByIdProductEntityGateway.existsById(id);
    }
}
