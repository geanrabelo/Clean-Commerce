package com.br.application.gateway.user;

import com.br.core.enums.Roles;

public interface CreateUserEntityGateway {
    void create(String login, String password, Roles roles);
}
