package com.br.infrastructure.exceptionsHandler.dto;

import java.util.List;

public record ErrorResponse(int status,
                            String message,
                            List<ErrorField> errorFields) {

}
