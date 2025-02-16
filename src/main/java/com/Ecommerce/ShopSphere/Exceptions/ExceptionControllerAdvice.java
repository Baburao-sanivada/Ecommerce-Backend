package com.Ecommerce.ShopSphere.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = CustomException.class)
    public final ResponseEntity<String> handleCustomException(CustomException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AuthenticationFailedExcep.class)
    public final ResponseEntity<String> handleAuthenticationFailed(AuthenticationFailedExcep excep){
        return new ResponseEntity<>(excep.getMessage(),HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = InvalidProductException.class)
    public final ResponseEntity<String> handleInvalidProduct(InvalidProductException excep){
        return new ResponseEntity<>(excep.getMessage(),HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = InvalidCartId.class)
    public final ResponseEntity<String> handleInvalidCartId(InvalidCartId excep){
        return new ResponseEntity<>(excep.getMessage(),HttpStatus.FORBIDDEN);
    }
    
}
