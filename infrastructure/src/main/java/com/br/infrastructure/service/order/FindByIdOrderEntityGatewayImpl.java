package com.br.infrastructure.service.order;

import com.br.application.gateway.order.FindByIdOrderEntityGateway;
import com.br.core.entities.OrderEntity;
import com.br.infrastructure.mapper.OrderMapper;
import com.br.infrastructure.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindByIdOrderEntityGatewayImpl implements FindByIdOrderEntityGateway {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderEntity findById(UUID id) {
        var order = orderRepository.findById(id).get();
        return orderMapper.toOrderEntityAll(order);
    }
}
