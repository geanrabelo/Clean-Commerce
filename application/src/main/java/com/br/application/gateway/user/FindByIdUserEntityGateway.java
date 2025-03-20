package com.br.application.gateway.user;

import com.br.core.entities.UserEntity;

public interface FindByIdUserEntityGateway {
    UserEntity findById(Long id);
}
