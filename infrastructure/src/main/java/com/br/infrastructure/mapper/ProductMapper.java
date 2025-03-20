package com.br.infrastructure.mapper;

import com.br.core.entities.ProductEntity;
import com.br.infrastructure.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    @Lazy
    @Autowired
    private OrderMapper orderMapper;

    public ProductEntity toProductEntity(Product product){
        return new ProductEntity(product.getName()
                , product.getQuantity()
                , product.getPrice());
    }
    public Product toProduct(ProductEntity product){
        return new Product(product.getName(),
                product.getQuantity(),
                product.getPrice());
    }

    public List<ProductEntity> toListProductEntity(List<Product> productList){
        List<ProductEntity> productEntity = new ArrayList<>();
        for(Product product : productList){
            productEntity.add(toProductEntity(product));
        }
        return productEntity;
    }

    public List<Product> toListProduct(List<ProductEntity> productEntityList){
        List<Product> productList = new ArrayList<>();
        for(ProductEntity productEntity : productEntityList){
            productList.add(
                    new Product(productEntity.getName()
                            , productEntity.getQuantity()
                            , productEntity.getPrice()));
        }
        return productList;
    }


}
