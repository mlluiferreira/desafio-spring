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

