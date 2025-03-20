package com.br.infrastructure.domain;

import com.br.core.entities.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "product")
@Entity(name = "product")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Product {


    public Product(String name, int quantity, float price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_uuid")
    private Order order;

    private float price;
}
