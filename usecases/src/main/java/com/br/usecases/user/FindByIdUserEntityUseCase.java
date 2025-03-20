package com.br.usecases.user;

import com.br.core.entities.UserEntity;

public interface FindByIdUserEntityUseCase {
    UserEntity findById(Long id);
}
