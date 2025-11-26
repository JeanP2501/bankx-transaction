package com.bankx.transactions_service.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalErrorHandler {	
	 
	@ExceptionHandler(BusinessException.class) 
	public Mono<ResponseEntity<Map<String, Object>>> handleBiz(BusinessException ex) { 
		return Mono.just(ResponseEntity.badRequest()
									   .body(Map.of("error",ex.getMessage()))); 
	}
	
	@ExceptionHandler(Exception.class) 
	public Mono<ResponseEntity<Map<String, Object>>> handleGen(Exception ex) { 
		return Mono.just(ResponseEntity.status(500)
									   .body(Map.of("error","internal_error"))); 
	}
	
    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<Map<String, Object>>> handleValidation(WebExchangeBindException ex) {
        Map<String, Object> errors = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );
        
        return Mono.just(ResponseEntity.badRequest()
                                       .body(Map.of("error", "validation_error", 
                                                    "details", errors)));
    }

}
