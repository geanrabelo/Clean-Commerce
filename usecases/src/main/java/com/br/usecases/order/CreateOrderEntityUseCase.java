package com.br.usecases.order;

import com.br.core.entities.ProductEntity;
import com.br.core.entities.UserEntity;

import java.util.List;
import java.util.UUID;

public interface CreateOrderEntityUseCase {
    UUID create(UserEntity user);
}