package com.br.usecases.user;

import com.br.core.enums.Roles;

public interface CreateUserEntityUseCase {
    void create(String name, String password, Roles roles);
}
