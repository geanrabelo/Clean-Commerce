package com.br.infrastructure.controller;

import com.br.infrastructure.dto.order.OrderCreatedDTO;
import com.br.infrastructure.dto.order.OrderFindDTO;
import com.br.infrastructure.dto.order.OrderResponseDTO;
import com.br.infrastructure.mapper.OrderMapper;
import com.br.infrastructure.mapper.UserMapper;
import com.br.infrastructure.repositories.UserRepository;
import com.br.usecases.order.CreateOrderEntityUseCase;
import com.br.usecases.order.DeleteByIdOrderEntityUseCase;
import com.br.usecases.order.FindByIdOrderEntityUseCase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/commerce/order")
public class OrderController {

    @Autowired
    private CreateOrderEntityUseCase createOrderEntityUseCase;

    @Autowired
    private FindByIdOrderEntityUseCase findByIdOrderEntityUseCase;

    @Autowired
    private DeleteByIdOrderEntityUseCase deleteByIdOrderEntityUseCase;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@RequestBody @Valid OrderResponseDTO orderResponseDTO, UriComponentsBuilder uriComponentsBuilder){
        var user = userRepository.findById(orderResponseDTO.id_user()).get();
        var userEntity = userMapper.toUserEntityWithId(user);
        UUID uuid = createOrderEntityUseCase.create(userEntity);
        var uri = uriComponentsBuilder.path("/commerce/order").buildAndExpand(user).toUri();
        return ResponseEntity.created(uri).body(new OrderCreatedDTO(uuid, user));
    }

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam(value = "uuid")UUID uuid){
        var orderEntity = findByIdOrderEntityUseCase.findById(uuid);
        var order = orderMapper.toOrderAll(orderEntity);
        return ResponseEntity.ok(new OrderFindDTO(order.getUuid(), order.getUser(), order.getPrice()));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> delete(@RequestParam(value = "uuid")UUID uuid){
        deleteByIdOrderEntityUseCase.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}
