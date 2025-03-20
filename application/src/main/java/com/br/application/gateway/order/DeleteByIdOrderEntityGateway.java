package com.br.application.gateway.order;

import java.util.UUID;

public interface DeleteByIdOrderEntityGateway {
    void deleteById(UUID id);
}
