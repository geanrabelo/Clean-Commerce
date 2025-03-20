package com.br.usecases.order;

import com.br.core.entities.ProductEntity;
import com.br.core.entities.UserEntity;

import java.util.List;

public interface CreateOrderEntityUseCase {
    void create(UserEntity user, float price);
}
