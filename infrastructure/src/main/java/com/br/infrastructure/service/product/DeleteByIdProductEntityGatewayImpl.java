package com.br.infrastructure.service.product;

import com.br.application.gateway.product.DeleteByIdProductEntityGateway;
import com.br.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteByIdProductEntityGatewayImpl implements DeleteByIdProductEntityGateway {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
