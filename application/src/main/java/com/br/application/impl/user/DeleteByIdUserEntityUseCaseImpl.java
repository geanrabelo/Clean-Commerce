package com.br.application.impl.user;

import com.br.application.gateway.user.DeleteByIdUserEntityGateway;
import com.br.usecases.user.DeleteByIdUserEntityUseCase;

public class DeleteByIdUserEntityUseCaseImpl implements DeleteByIdUserEntityUseCase {

    private DeleteByIdUserEntityGateway deleteByIdUserEntityGateway;

    public DeleteByIdUserEntityUseCaseImpl(DeleteByIdUserEntityGateway deleteByIdUserEntityGateway){
        this.deleteByIdUserEntityGateway = deleteByIdUserEntityGateway;
    }
    @Override
    public void deleteById(Long id) {
        deleteByIdUserEntityGateway.deleteById(id);
    }
}
