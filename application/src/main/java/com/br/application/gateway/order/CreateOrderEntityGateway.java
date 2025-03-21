package com.br.application.gateway.order;

import com.br.core.entities.ProductEntity;
import com.br.core.entities.UserEntity;

import java.util.List;
import java.util.UUID;

public interface CreateOrderEntityGateway {
    UUID create(UserEntity userEntity);
}
