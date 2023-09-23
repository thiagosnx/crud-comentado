package com.crudexample.domain.product;


//Integer no price pq ele recebe um JSON, nao um number
public record RequestProduct(//criamos esse record que é um DTO, usado p transferir dados
        String name,
        Integer price_in_cents,

        //aqui o id nao é obrigatorio, usaremos so pro putmapping e delete
        String id) {
    //passamos como parametro as coisas que sao requiridas no body => name e price, o id é gerado automaticamente

}
