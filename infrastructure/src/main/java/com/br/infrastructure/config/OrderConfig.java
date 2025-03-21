package com.br.infrastructure.config;

import com.br.application.gateway.order.CreateOrderEntityGateway;
import com.br.application.gateway.order.DeleteByIdOrderEntityGateway;
import com.br.application.gateway.order.ExistsByIdOrderEntityGateway;
import com.br.application.gateway.order.FindByIdOrderEntityGateway;
import com.br.application.impl.order.CreateOrderEntityUseCaseImpl;
import com.br.application.impl.order.DeleteByIdOrderEntityUseCaseImpl;
import com.br.application.impl.order.FindByIdOrderEntityUseCaseImpl;
import com.br.infrastructure.service.order.CreateOrderEntityGatewayImpl;
import com.br.infrastructure.service.order.DeleteByIdOrderEntityGatewayImpl;
import com.br.usecases.order.CreateOrderEntityUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OrderConfig {

    @Bean
    public CreateOrderEntityUseCaseImpl createOrderEntityUseCase(CreateOrderEntityGateway createOrderEntityGateway){
        return new CreateOrderEntityUseCaseImpl(createOrderEntityGateway);
    }

    @Bean
    public FindByIdOrderEntityUseCaseImpl findByIdOrderEntityUseCase(FindByIdOrderEntityGateway findByIdOrderEntityGateway, ExistsByIdOrderEntityGateway existsByIdOrderEntityGateway){
        return new FindByIdOrderEntityUseCaseImpl(findByIdOrderEntityGateway, existsByIdOrderEntityGateway);
    }

    @Bean
    public DeleteByIdOrderEntityUseCaseImpl deleteByIdOrderEntityUseCase(DeleteByIdOrderEntityGateway deleteByIdOrderEntityGateway){
        return new DeleteByIdOrderEntityUseCaseImpl(deleteByIdOrderEntityGateway);
    }

}
