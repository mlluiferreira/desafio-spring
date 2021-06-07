# Desafio-Spring
Repositório responsável por conter o desenvolvimento de um sistema web proposto por um desafio da digital house e mercado livre.
Para isso foi construído uma API com o Spring Framework e banco de dados em memória com H2.

## Recursos Utilizados: :computer:
Para o desenvolvimento do projeto foi utilizado as seguintes aplicações/Frameworks :

* [H2 Database Engine](https://www.h2database.com/html/main.html)
* [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
* [Spring Framework](https://spring.io/)
* [Swagger](https://swagger.io/)

## Executando o Projeto Localmente :fire:

Após ter baixado o projeto deste repositório, basta ir até a pasta raiz e executar o comando abaixo:

```
> mvn spring-boot:run
```

Esse comando irá baixar todas as dependências e executar o programa ao fim.

## Acessando o banco de dados :floppy_disk:

O banco de dados utilizado é o H2 Database Engine, um banco de dados SQL em memória construído utilizando o java, o mesmo estará disponível no endpoint abaixo após a aplicação inicializar.

```
http://localhost:8080/h2-console/
```

Para realizar login o formulário deve estar preenchido da forma a seguir.

| Propriedade  | Valor              |
| ------------ | ------------------ |
| Driver Class | org.h2.Driver      |
| JDBC URL     | jdbc:h2:mem:testdb |
| User Name    | sa                 |
| Password     |                    |

No banco já existem alguns clientes e produtos cadastrados, conforme índices a seguir:

| Entidade | Índices                                      |
| -------- | -------------------------------------------- |
| Cliente  | >= 6 e <= 15                                 |
| Vendedor | >= 11 e <= 15 (Vendedor também é um cliente) |
| Produtos | >= 1 e <= 5                                  |

## Acessando o Swagger

O swagger estará disponível após a inicialização da aplicação no endpoint abaixo:

```
http://localhost:8080/swagger-ui.html
```



# End-Points



## End-point: 01 - cliente seguir um vendedor

### Descrição: Permite um usuário seguir um vendedor

Method: POST

>```
>localhost:8080/users/{userIdFollowing}/follow/{sellerIdFollowed}
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 01 - vendedor seguir um vendedor

### Descrição: Também é possível um vendedor seguir outro vendedor

Method: POST

>```
>localhost:8080/users/{sellerIdFollowing}/follow/{sellerIdFollowed}
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 02 - quantidade usuários que seguem vendedor

### Descrição: Permite visualizar a quantidade de seguidores que um determinado vendedor possui

Method: GET

>```
>localhost:8080/users/{sellerId}/followers/count
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 03 - lista usuários que seguem vendedor

### Descrição: Path que lista todos os usuários que seguem um determinado vendedor

Method: GET

>```
>localhost:8080/users/{sellerId}/followers/list
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 04 - lista de quem usuário segue

### Descrição: Lista todos os vendedores que um usuário segue

Method: GET

>```
>localhost:8080/users/{userId}/followed/list
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 05 - criar uma nova publicação

### Descrição: Permite que um vendedor crie uma publicação

Method: POST

>```
>localhost:8080/product/newpost
>```

### Body (**raw**)

```json
{
  "userId": {sellerId:Number},
  "category": {category:String},
  "productId": {productId:Number},
  "price": {price:Number}
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 06 - obter lista de post de vendedores que usuário segue

### Descrição: Obtém todas as publicações de todos os vendedores seguido por um usuário

Method: GET

>```
>localhost:8080/product/followed/{userId}/list
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 07 - parar de seguir um usuário

### Descrição: Permite um usuário parar de seguir um vendedor

Method: POST

>```
>localhost:8080/users/{userId}/unfollow/{sellerId}
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 08 - ordenar alfabeticamente lista de seguidores vendedor

### Descrição: Retorna todos os seguidores de um vendedor ordenado alfabeticamente

Method: GET

>```
>localhost:8080/users/{sellerId}/followers/list?order=name_?
>```

### Query Params

| Param | value              |
| ----- | ------------------ |
| order | name_desc/name_asc |



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 09 - ordenar por data lista de quem usuário segue

### Descrição: Obtém lista de publicações de vendedores que um usuário segue ordenada pela data

Method: GET

>```
>localhost:8080/product/followed/{userId}/list?order=date_?
>```

### Query Params

| Param | value              |
| ----- | ------------------ |
| order | date_asc/date_desc |



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 10 - criar post promocional

### Descrição: Permite um vendedor criar um post promocional

Method: POST

>```
>localhost:8080/product/newpromopost
>```

### Body (**raw**)

```json
{
  "userId": {sellerId:Number},
  "category": {category:String},
  "productId": {productId:Number},
  "price": {price:Number},
  "hasPromo": true,
  "discount": {discount:Number}
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 11 - contar post promocional vendedor

### Descrição: Permite obter a quantidade de posts promocionais de um vendedor

Method: GET

>```
>localhost:8080/product/{sellerId}/countPromo
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃


## End-point: 12 - obter post promocional vendedor

### Descrição: Obtém uma lista contendo todos os posts promocionais de um vendedor

Method: GET

>```
>localhost:8080/product/{sellerId}/list
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
