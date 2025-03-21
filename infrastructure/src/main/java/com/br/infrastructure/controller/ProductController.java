package com.br.infrastructure.controller;

import com.br.core.exceptions.ProductNotFound;
import com.br.infrastructure.domain.Product;
import com.br.infrastructure.dto.product.ProductCreatedDTO;
import com.br.infrastructure.dto.product.ProductFindDTO;
import com.br.infrastructure.dto.product.ProductResponseDTO;
import com.br.infrastructure.mapper.ProductMapper;
import com.br.infrastructure.repositories.OrderRepository;
import com.br.usecases.product.CreateProductEntityUseCase;
import com.br.usecases.product.DeleteByIdProductEntityUseCase;
import com.br.usecases.product.FindByIdProductEntityUseCase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/commerce/product")
public class ProductController {

    @Autowired
    private CreateProductEntityUseCase createProductEntityUseCase;

    @Autowired
    private FindByIdProductEntityUseCase findByIdProductEntityUseCase;

    @Autowired
    private DeleteByIdProductEntityUseCase deleteByIdProductEntityUseCase;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderRepository orderRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@RequestBody @Valid ProductResponseDTO productResponseDTO, UriComponentsBuilder uriComponentsBuilder){
        var uuid = UUID.fromString(productResponseDTO.order_uuid());
        var order = orderRepository.findById(uuid).get();
        var product = new Product(productResponseDTO.name(), productResponseDTO.quantity(), productResponseDTO.price(), order);
        var productEntity = productMapper.toProductEntity(product);
        createProductEntityUseCase.create(productEntity);
        var uri = uriComponentsBuilder.path("/commerce/product").buildAndExpand(product).toUri();
        return ResponseEntity.created(uri).body(new ProductCreatedDTO(product));
    }

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam(value = "id") Long id) throws ProductNotFound {
        var productEntity = findByIdProductEntityUseCase.findById(id);
        return ResponseEntity.ok(new ProductFindDTO(productEntity));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        deleteByIdProductEntityUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
