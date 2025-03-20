package com.br.infrastructure.mapper;

import com.br.core.entities.UserEntity;
import com.br.infrastructure.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toUserEntity(User user){
        return new UserEntity(user.getLogin(), user.getPassword(), user.getRoles());
    }

    public User toUser(UserEntity userEntity){
        return new User(userEntity.getLogin(), userEntity.getPassword(), userEntity.getRoles());
    }
}
