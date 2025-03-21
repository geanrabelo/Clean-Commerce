package com.br.infrastructure.service.user;

import com.br.application.gateway.user.ExistsByIdUserEntityGateway;
import com.br.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExistsByIdUserEntityGatewayImpl implements ExistsByIdUserEntityGateway {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
