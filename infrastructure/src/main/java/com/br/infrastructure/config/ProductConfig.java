package com.br.infrastructure.config;

import com.br.application.gateway.product.CreateProductEntityGateway;
import com.br.application.gateway.product.DeleteByIdProductEntityGateway;
import com.br.application.gateway.product.FindByIdProductEntityGateway;
import com.br.application.impl.product.CreateProductEntityUseCaseImpl;
import com.br.application.impl.product.DeleteByIdProductEntityUseCaseImpl;
import com.br.application.impl.product.FindByIdProductEntityUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public CreateProductEntityUseCaseImpl createProductEntityUseCase(CreateProductEntityGateway createProductEntityGateway){
        return new CreateProductEntityUseCaseImpl(createProductEntityGateway);
    }

    @Bean
    public FindByIdProductEntityUseCaseImpl findByIdProductEntityUseCase(FindByIdProductEntityGateway findByIdProductEntityGateway){
        return new FindByIdProductEntityUseCaseImpl(findByIdProductEntityGateway);
    }

    @Bean
    public DeleteByIdProductEntityUseCaseImpl deleteByIdProductEntityUseCase(DeleteByIdProductEntityGateway deleteByIdProductEntityGateway){
        return new DeleteByIdProductEntityUseCaseImpl(deleteByIdProductEntityGateway);
    }
}
