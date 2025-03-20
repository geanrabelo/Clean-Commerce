package com.br.infrastructure.repositories;

import com.br.infrastructure.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
