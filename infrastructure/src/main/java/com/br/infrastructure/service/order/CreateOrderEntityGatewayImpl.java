package com.br.infrastructure.service.order;

import com.br.application.gateway.order.CreateOrderEntityGateway;
import com.br.core.entities.UserEntity;
import com.br.infrastructure.domain.Order;
import com.br.infrastructure.mapper.UserMapper;
import com.br.infrastructure.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateOrderEntityGatewayImpl implements CreateOrderEntityGateway {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UUID create(UserEntity userEntity) {
        var order = new Order(userMapper.toUserWithId(userEntity));
        orderRepository.save(order);
        return orderRepository.findById(order.getUuid()).get().getUuid();
    }
}
