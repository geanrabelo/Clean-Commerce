package com.br.infrastructure.config;

import com.br.application.gateway.user.CreateUserEntityGateway;
import com.br.application.gateway.user.DeleteByIdUserEntityGateway;
import com.br.application.gateway.user.ExistsByIdUserEntityGateway;
import com.br.application.gateway.user.FindByIdUserEntityGateway;
import com.br.application.impl.user.CreateUserEntityUseCaseImpl;
import com.br.application.impl.user.DeleteByIdUserEntityUseCaseImpl;
import com.br.application.impl.user.FindByIdUserEntityUseCaseImpl;
import com.br.infrastructure.service.user.CreateUserEntityGatewayImpl;
import com.br.usecases.user.FindByIdUserEntityUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public CreateUserEntityUseCaseImpl createUserEntityUseCase(CreateUserEntityGateway createUserEntityGateway){
        return new CreateUserEntityUseCaseImpl(createUserEntityGateway);
    }


    @Bean
    public DeleteByIdUserEntityUseCaseImpl deleteByIdUserEntityUseCase(DeleteByIdUserEntityGateway deleteByIdUserEntityGateway){
        return new DeleteByIdUserEntityUseCaseImpl(deleteByIdUserEntityGateway);
    }

    @Bean
    public FindByIdUserEntityUseCaseImpl FindByIdUserEntityUseCaseImpl(FindByIdUserEntityGateway findByIdUserEntityGateway, ExistsByIdUserEntityGateway existsByIdUserEntityGateway){
        return new FindByIdUserEntityUseCaseImpl(findByIdUserEntityGateway, existsByIdUserEntityGateway);
    }
}
