package com.podstore.controllers;


import com.podstore.domain.product.Product;
import com.podstore.domain.product.ProductRepository;

import com.podstore.domain.product.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


//bem- vindo, os controllers recebem as requisições dos usuários
//apontamos o endpoint atraves do requestmapping
@RestController //anotação de cntroller
@RequestMapping("/product") // endpoint
public class ProductController {


    @Autowired //usamos o autowired para injetar o nosso repository aqui, para podermos usar os metodos do jpa
    private ProductRepository repository; //criamos essa instancia dele e ja podemos usar

    @GetMapping // criamos um metodo pro nosso controller
    public ResponseEntity getAllProducts(){
        var allProducts = repository.findAll(); // usamos o var do lombok para declarar a variável allProducts
        //depois, usamos a instancia q criamos, repository, com um metodo do JpaRepository "findall" e pronto, obtemos

        return ResponseEntity.ok(allProducts); // agora, retornamos a nossa variável, que terá todos os products.
    }
    // o responseEntity é simplesmente uma resposta que volta para o usuario se der 200
    //para testarmos o metodo, vamos para o PostMan e damos continuidade no código

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Validated RequestProduct data){ //o validated valida os parametros do record request
        //o requestbody exige o body do sql/tabela p poder registrar o produto
        //criamos um record RequestProduct que ficará no domain junto com o repository e product como parametro


        Product newProduct = new Product(data);//para salvar algo no DB, precisamos manipular a entidade Product
        //para isso, criamos essa instancia e dentro da Entidade criamos uma classe Product
        //manualmente com o construtor que recebe como parametro o RequestProduct (data) p podermos instanciar aqui

        repository.save(newProduct);//usando aquele velho metodo que criamos para manipular o DB, passamos um save
        //e ele ira slvar o newProduct, que acabmos de instanciar, o qual recebe o requestbody como parametro


        return ResponseEntity.ok().build(); // precisamos do build se o repsonseentity estiver vazio

        //pronto, para testar, usamos o Postman e damos continuidade se estiver tudo certo


    }

    @PutMapping
    @Transactional//colocamos o transactional para poder mudar os dados do DB
    public ResponseEntity updateProduct(@RequestBody @Validated RequestProduct data){

        //usaremos o msm request para agilizar, mas poderiamos criar outro que aceita valores nulos e tal, vai q é um desses q eu preciso editar
        Optional<Product> optionalProduct = repository.findById(data.id());
        //usando o findbyid temos q colocar opcional, pois isso pode estar vazio
        //fazemos um if para ver se o opcional is present da certo, e o else dá errado
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            //aqui criamos outra variavel pela entidade Product, usando o repository para usar os metodos Jpa
            //pegamos a referencia por Id do requestProduct (data)
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);
        }else {
            return ResponseEntity.notFound().build();
        }


        //agora passamos o SET das nossas 'colunas' para setar novos valores no nosso 'data' do requestProduct


    }

}
