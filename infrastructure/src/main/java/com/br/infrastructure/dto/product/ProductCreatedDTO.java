package com.br.infrastructure.dto.product;

import com.br.infrastructure.domain.Product;

import java.util.UUID;

public record ProductCreatedDTO(String name,
                                 int quantity,
                                 String order_uuid,
                                 float price) {

    public ProductCreatedDTO(Product product){
        this(product.getName(), product.getQuantity(), String.valueOf(product.getOrder().getUuid()), product.getPrice());
    }

}
