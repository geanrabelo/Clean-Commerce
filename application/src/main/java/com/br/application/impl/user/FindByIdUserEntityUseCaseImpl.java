package com.br.application.impl.user;

import com.br.application.gateway.user.FindByIdUserEntityGateway;
import com.br.core.entities.UserEntity;
import com.br.usecases.user.FindByIdUserEntityUseCase;

public class FindByIdUserEntityUseCaseImpl implements FindByIdUserEntityUseCase {

    private FindByIdUserEntityGateway findByIdUserEntityGateway;

    public FindByIdUserEntityUseCaseImpl(FindByIdUserEntityGateway findByIdUserEntityGateway){
        this.findByIdUserEntityGateway = findByIdUserEntityGateway;
    }
    @Override
    public UserEntity findById(Long id) {
        return findByIdUserEntityGateway.findById(id);
    }
}
