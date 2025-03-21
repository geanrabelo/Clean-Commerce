package com.br.infrastructure.dto.product;

import java.util.UUID;

public record ProductResponseDTO(String name,
                                 int quantity,
                                 String order_uuid,
                                 float price) {
}
