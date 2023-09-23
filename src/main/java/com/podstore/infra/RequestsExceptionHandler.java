package com.podstore.infra;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice //responsavel por lidar com exceções
public class RequestsExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)//trata as exceções antes de chegar ao usuario
    public ResponseEntity threat404(){
        return ResponseEntity.badRequest().body("Dado não encontrado!");//todas exceptions voltam isso
        //criamos a exception p retornar algo menos feio pro usuario e nao mostrar muito da nossa arq

    }

}
