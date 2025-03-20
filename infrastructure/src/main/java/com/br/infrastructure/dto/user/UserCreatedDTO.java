package com.br.infrastructure.dto.user;

import com.br.core.enums.Roles;
import com.br.infrastructure.domain.User;

public record UserCreatedDTO(String login, String password, Roles roles) {

    public UserCreatedDTO(User user){
        this(user.getLogin(), user.getPassword(), user.getRoles());
    }
}
