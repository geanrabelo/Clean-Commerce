package com.br.infrastructure.service.user;

import com.br.application.gateway.user.CreateUserEntityGateway;
import com.br.core.enums.Roles;
import com.br.infrastructure.domain.User;
import com.br.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserEntityGatewayImpl implements CreateUserEntityGateway {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(String login, String password, Roles roles) {
        userRepository.save(new User(login, password, roles));
    }
}
