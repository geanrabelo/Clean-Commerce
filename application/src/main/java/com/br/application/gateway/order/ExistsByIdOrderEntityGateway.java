package com.br.application.gateway.order;

import java.util.UUID;

public interface ExistsByIdOrderEntityGateway {
    boolean existsById(UUID id);
}
