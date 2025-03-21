package com.br.infrastructure.controller;

import com.br.infrastructure.domain.User;
import com.br.infrastructure.dto.user.UserCreatedDTO;
import com.br.infrastructure.dto.user.UserFindDTO;
import com.br.infrastructure.dto.user.UserResponseDTO;
import com.br.usecases.user.CreateUserEntityUseCase;
import com.br.usecases.user.DeleteByIdUserEntityUseCase;
import com.br.usecases.user.FindByIdUserEntityUseCase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/commerce/user")
public class UserController {


    public UserController(){}

    @Autowired
    private CreateUserEntityUseCase createUserEntityUseCase;

    @Autowired
    private DeleteByIdUserEntityUseCase deleteByIdUserEntityUseCase;

    @Autowired
    private FindByIdUserEntityUseCase findByIdUserEntityUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@RequestBody @Valid UserResponseDTO userResponseDTO, UriComponentsBuilder uriComponentsBuilder){
        var user = new User(userResponseDTO.login(), userResponseDTO.password(), userResponseDTO.roles());
        createUserEntityUseCase.create(userResponseDTO.login(), userResponseDTO.password(), userResponseDTO.roles());
        var uri = uriComponentsBuilder.path("/commerce/user").buildAndExpand(user).toUri();
        return ResponseEntity.created(uri).body(new UserCreatedDTO(user));
    }

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam(value = "id") Long id){
        var userEntity = findByIdUserEntityUseCase.findById(id);
        return ResponseEntity.ok(new UserFindDTO(id, userEntity));
    }


    @DeleteMapping
    @Transactional
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        deleteByIdUserEntityUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
