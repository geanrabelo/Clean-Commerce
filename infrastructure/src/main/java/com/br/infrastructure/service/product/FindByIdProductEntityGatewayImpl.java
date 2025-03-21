package com.br.infrastructure.service.product;

import com.br.application.gateway.product.FindByIdProductEntityGateway;
import com.br.core.entities.ProductEntity;
import com.br.infrastructure.mapper.ProductMapper;
import com.br.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindByIdProductEntityGatewayImpl implements FindByIdProductEntityGateway {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductEntity findById(Long id) {
        var product = productRepository.findById(id).get();
        return productMapper.toProductEntityAll(product);
    }
}
