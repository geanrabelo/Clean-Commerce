package com.br.infrastructure.service.order;

import com.br.application.gateway.order.DeleteByIdOrderEntityGateway;
import com.br.infrastructure.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteByIdOrderEntityGatewayImpl implements DeleteByIdOrderEntityGateway {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void deleteById(UUID id) {
        orderRepository.deleteById(id);
    }
}
