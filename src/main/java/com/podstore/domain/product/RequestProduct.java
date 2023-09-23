package com.podstore.domain.product;

//Integer no price pq ele recebe um JSON, nao um number
public record RequestProduct(String name, Integer price_in_cents) { //criamos esse record que é um DTO, usado p transferir dados
    //passamos como parametro as coisas que sao requiridas no body => name e price, o id é gerado automaticamente

}
