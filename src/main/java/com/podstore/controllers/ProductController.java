package com.podstore.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//bem- vindo, os controllers recebem as requisições dos usuários
//apontamos o endpoint atraves do requestmapping
@RestController
@RequestMapping("/product") // endpoint
public class ProductController {
    @GetMapping // criamos um metodo pro nosso controller
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok("deu ok");
    }
    // o responseEntity é simplesmente uma resposta que volta para o usuario se der 200
}
