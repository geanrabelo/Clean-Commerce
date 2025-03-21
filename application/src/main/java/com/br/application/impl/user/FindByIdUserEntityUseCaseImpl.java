package com.br.application.impl.user;

import com.br.application.gateway.user.ExistsByIdUserEntityGateway;
import com.br.application.gateway.user.FindByIdUserEntityGateway;
import com.br.core.entities.UserEntity;
import com.br.core.exceptions.UserNotFound;
import com.br.usecases.user.FindByIdUserEntityUseCase;

public class FindByIdUserEntityUseCaseImpl implements FindByIdUserEntityUseCase {

    private FindByIdUserEntityGateway findByIdUserEntityGateway;
    private ExistsByIdUserEntityGateway existsByIdUserEntityGateway;

    public FindByIdUserEntityUseCaseImpl(FindByIdUserEntityGateway findByIdUserEntityGateway, ExistsByIdUserEntityGateway existsByIdUserEntityGateway){
        this.findByIdUserEntityGateway = findByIdUserEntityGateway;
        this.existsByIdUserEntityGateway = existsByIdUserEntityGateway;
    }
    @Override
    public UserEntity findById(Long id) throws UserNotFound {
        if(!existsByIdUserEntityGateway.existsById(id)){
            throw new UserNotFound("User searched by id not found!");
        }
        return findByIdUserEntityGateway.findById(id);
    }
}
