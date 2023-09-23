package com.crudexample.domain.product;


import jakarta.persistence.*;
import lombok.*;
//bem-vindo, essa é a clase ENTIDADE,que representa a nossa tabela, mas nao dá pra manipular por aqui
//para manipulá-la, usaremos os Repositorys

//lembrando que criaremos os nossos codigos SQL pelo db.migrations
//o FlyWay procura o arquivo dentro do db.migrations e executa os comandos sql que estao lá dentro
@Table(name="product")
@Entity(name="product") // entity representa o nosso banco de dados, precisamos criar as coisas aqui representando as colunas do db
@Getter //getter, setter e contructors criados com lombok
@Setter
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(of = "id")  // identifica a PrimaryKey do nosso DB
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID) // mais uma vez, o @Id representa a PK
    // o generatedvalue fica responsavel por gerar um id aleatorio para nos com o UUID
    private String id;

    private String name;

    private Integer price_in_cents;

    private Boolean active;

    public Product(RequestProduct requestProduct){
        // passamos o request no parametro para ele poder receber o (data) como parametro na isntnaica
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
        this.active = true;
        // criamos os contrutores manualmente
    }





}
