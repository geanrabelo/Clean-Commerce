package com.br.infrastructure.service.product;

import com.br.application.gateway.product.CreateProductEntityGateway;
import com.br.core.entities.ProductEntity;
import com.br.infrastructure.mapper.OrderMapper;
import com.br.infrastructure.mapper.ProductMapper;
import com.br.infrastructure.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductEntityGatewayImpl implements CreateProductEntityGateway {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void create(ProductEntity product) {
        productRepository.save(productMapper.toProduct(product));
    }
}
