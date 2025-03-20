package com.br.infrastructure.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "order")
@Table(name = "order")
@Data
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor
public class Order {

    public Order(User user, float price){
        this.user = user;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private float price;

    @OneToMany(mappedBy = "order")
    private List<Product> productList;
}
