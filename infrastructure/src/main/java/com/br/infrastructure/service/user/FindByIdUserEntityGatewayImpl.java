package com.br.infrastructure.service.user;

import com.br.application.gateway.user.FindByIdUserEntityGateway;
import com.br.core.entities.UserEntity;
import com.br.infrastructure.mapper.UserMapper;
import com.br.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindByIdUserEntityGatewayImpl implements FindByIdUserEntityGateway {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserEntity findById(Long id) {
        return userMapper.toUserEntity(userRepository.getReferenceById(id));
    }
}
