package com.br.application.impl.user;

import com.br.application.gateway.user.CreateUserEntityGateway;
import com.br.core.enums.Roles;
import com.br.usecases.user.CreateUserEntityUseCase;

public class CreateUserEntityUseCaseImpl implements CreateUserEntityUseCase {

    private CreateUserEntityGateway createUserEntityGateway;

    public CreateUserEntityUseCaseImpl(CreateUserEntityGateway createUserEntityGateway){
        this.createUserEntityGateway = createUserEntityGateway;
    }

    @Override
    public void create(String name, String password, Roles roles) {
        createUserEntityGateway.create(name, password, roles);
    }
}
