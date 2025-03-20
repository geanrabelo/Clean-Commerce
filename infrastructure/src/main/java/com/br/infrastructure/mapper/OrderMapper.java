package com.br.infrastructure.mapper;

import com.br.core.entities.OrderEntity;
import com.br.infrastructure.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    @Lazy
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    public OrderEntity toOrderEntity(Order order){
        var listProductentity = productMapper.toListProductEntity(order.getProductList());

        return new OrderEntity(
                userMapper.toUserEntity(order.getUser())
                , order.getPrice());
    }

    public Order toOrder(OrderEntity orderEntity){
        return new Order(
                userMapper.toUser(orderEntity.getUser())
                , orderEntity.getPrice());
    }
}
