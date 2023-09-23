package com.podstore.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue(); //criando um metodo pro JPA que procura todos com o active = true
}
//criamos essa interface someente para ter os nosso metodos online.
//tipo find, findall, findbyid
//a partir dai o nosso controller conseguirá usar esses metodos para manipular o DB
