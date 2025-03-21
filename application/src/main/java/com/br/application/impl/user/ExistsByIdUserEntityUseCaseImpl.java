package com.br.application.impl.user;

import com.br.application.gateway.user.ExistsByIdUserEntityGateway;
import com.br.usecases.user.ExistsByIdUserEntityUseCase;

public class ExistsByIdUserEntityUseCaseImpl implements ExistsByIdUserEntityUseCase {

    private ExistsByIdUserEntityGateway existsByIdUserEntityGateway;

    public ExistsByIdUserEntityUseCaseImpl(ExistsByIdUserEntityGateway existsByIdUserEntityGateway){
        this.existsByIdUserEntityGateway = existsByIdUserEntityGateway;
    }
    @Override
    public boolean existsById(Long id) {
        return existsByIdUserEntityGateway.existsById(id);
    }
}
