package com.br.usecases.order;

import java.util.UUID;

public interface ExistsByIdOrderEntityUseCase {
    boolean existsById(UUID id);
}
