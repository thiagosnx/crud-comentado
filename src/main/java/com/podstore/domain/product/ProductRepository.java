package com.podstore.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
//criamos essa interface someente para ter os nosso metodos online.
//tipo find, findall, findbyid
//a partir dai o nosso controller conseguirá usar esses metodos para manipular o DB
