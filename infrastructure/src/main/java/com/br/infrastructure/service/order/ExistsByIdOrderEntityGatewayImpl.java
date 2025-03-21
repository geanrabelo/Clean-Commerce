package com.br.infrastructure.service.order;

import com.br.application.gateway.order.ExistsByIdOrderEntityGateway;
import com.br.infrastructure.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExistsByIdOrderEntityGatewayImpl implements ExistsByIdOrderEntityGateway {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean existsById(UUID id) {
        return orderRepository.existsById(id);
    }
}
