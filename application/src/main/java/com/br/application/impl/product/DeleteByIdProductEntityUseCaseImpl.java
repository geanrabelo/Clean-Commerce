package com.br.application.impl.product;

import com.br.application.gateway.product.DeleteByIdProductEntityGateway;
import com.br.usecases.product.DeleteByIdProductEntityUseCase;

public class DeleteByIdProductEntityUseCaseImpl implements DeleteByIdProductEntityUseCase {

    private DeleteByIdProductEntityGateway deleteByIdProductEntityGateway;

    public DeleteByIdProductEntityUseCaseImpl(DeleteByIdProductEntityGateway productEntityGateway){
        this.deleteByIdProductEntityGateway = productEntityGateway;
    }
    @Override
    public void deleteById(Long id) {
        deleteByIdProductEntityGateway.deleteById(id);
    }
}
