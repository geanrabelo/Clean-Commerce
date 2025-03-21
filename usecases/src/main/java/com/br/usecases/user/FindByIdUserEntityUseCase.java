package com.br.usecases.user;

import com.br.core.entities.UserEntity;
import com.br.core.exceptions.UserNotFound;

public interface FindByIdUserEntityUseCase {
    UserEntity findById(Long id) throws UserNotFound;
}
