package com.br.infrastructure.service.product;

import com.br.application.gateway.product.ExistsByIdProductEntityGateway;
import com.br.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExistsByIdProductEntityGatewayImpl implements ExistsByIdProductEntityGateway {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }
}
