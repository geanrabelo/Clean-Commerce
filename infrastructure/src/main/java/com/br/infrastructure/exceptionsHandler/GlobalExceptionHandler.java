package com.br.infrastructure.exceptionsHandler;

import com.br.core.exceptions.OrderNotFound;
import com.br.core.exceptions.ProductNotFound;
import com.br.core.exceptions.UserNotFound;
import com.br.infrastructure.exceptionsHandler.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse OrderNotFoundHandler(OrderNotFound orderNotFound){
        return ErrorResponse.notFound(orderNotFound.getMessage());
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse ProductNotFoundHandler(ProductNotFound productNotFound){
        return ErrorResponse.notFound(productNotFound.getMessage());
    }

    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse UserNotFoundHandler(UserNotFound userNotFound){
        return ErrorResponse.notFound(userNotFound.getMessage());
    }
}
