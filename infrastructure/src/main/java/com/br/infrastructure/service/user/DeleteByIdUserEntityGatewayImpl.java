package com.br.infrastructure.service.user;

import com.br.application.gateway.user.DeleteByIdUserEntityGateway;
import com.br.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteByIdUserEntityGatewayImpl implements DeleteByIdUserEntityGateway {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
