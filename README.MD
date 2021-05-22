## Rest API CRUD Clientes em Java

<h4 align="left">
 CRUD Clientes 🚀 Concluído 🚀
</h4>

<!--ts-->
* [Autor](#autor)
* [Features](#features)
* [Tecnologias](#tecnologias)
* [Pre-requisitos](#prerequisitos)
* [Baixar e executar](#baixar)
* [Exemplo de utilização dos verbos HTML](#como-usar)
    * [POST](#exemplo-json-body-post)
    * [PUT](#exemplo-json-body-put)
    * [GET by ID](#exemplo-json-sada-get-by-id)
    * [GET all pageable](#exemplo-json-sada-get-all-pageable)
<!--te-->

---

### Autor

<a href="https://www.linkedin.com/in/marcelomachado1987/">
 <img style="border-radius: 50%;" src="https://media-exp1.licdn.com/dms/image/C4E03AQEwV54JjLc-9g/profile-displayphoto-shrink_800_800/0/1621682542460?e=1626912000&v=beta&t=Ctis1Z8wFBsNtnuMhTXGp7cXWA12JyY5t9KF9rfQf58" width="100px;" alt=""/>
 <br />
Feito por <b>Marcelo Machado</b></a>
 <br />

---

### Features

- [x] Cadastro de Clientes com verbo POST /clients
- [x] Busca de Clientes pagindo com verbo GET /clients
- [x] Busca de Clientes por id com verbo GET /clients/id
- [x] Update de Clientes por id com verbo PUT /clients/id
- [x] Deletar Clientes por id com verbo DELETE /clients/id

---

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Spring Boot](https://spring.io/projects)
- [Java 11](https://docs.oracle.com/en/java/javase/11/)
- [Hibernate + JPA](https://hibernate.org/)
- [SQL]

--

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:

* IDE para desenvolvimento JAVA como Inteliji(a mesma que usei) ou Spring Tool Suite 4
* Gerenciador de dependencias maven
* para testar os verbos HTTP utilize o Insominia ou Postman

---

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/MarceloMachadoxD/APICrudClientesSpringBootJPA.git>

# Importe o projeto na sua IDE

# Aguarde a sincronização das dependencias do Maven

# Execute a aplicação (está no profile test por se tratar de um projeto desenvolvido com intuito de estudo)

#caso queira alterar o seed do banco de dados altere os dados no arquivo resoruces/data.sql

# O servidor inciará na porta:8080 - abra o Insominia/Postman e execute os verbos HTML na url <http://localhost:8080/clients>

```

---

###Exemplo JSON body POST
#### Enviar no caminho: http://localhost:8080/clients
```bash
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

###Exemplo JSON body PUT
#### Enviar no caminho: http://localhost:8080/clients
```bash
{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```


###Exemplo JSON Saída GET by ID
#### Enviar no caminho: http://localhost:8080/clients/4
```bash
{
  "id": 4,
  "name": "Ibere Thenorio",
  "cpf": "12585269354",
  "income": 3975.44,
  "birthDate": "1920-07-13T20:50:07.123450Z",
  "children": 0
}
```

###Exemplo JSON Saída GET all pageable
#### Enviar no caminho: http://localhost:8080/clients?page=0&linesPerPage=6&direction=ASC&orderBy=name
```bash
{
  "content": [
    {
      "id": 13,
      "name": "Ada Lovelace",
      "cpf": "12585269354",
      "income": 3996.44,
      "birthDate": "1920-07-13T20:50:07.123450Z",
      "children": 1
    },
    {
      "id": 10,
      "name": "Alan turing",
      "cpf": "12585269354",
      "income": 3037.44,
      "birthDate": "1920-07-13T20:50:07.123450Z",
      "children": 6
    },
    {
      "id": 3,
      "name": "Albert Einstein",
      "cpf": "12565236301",
      "income": 3025.44,
      "birthDate": "1920-07-13T20:50:07.123450Z",
      "children": 1
    },
    {
      "id": 1,
      "name": "Alexander Gran Bell",
      "cpf": "12585269354",
      "income": 3584.44,
      "birthDate": "1920-07-13T20:50:07.123450Z",
      "children": 2
    },
    {
      "id": 8,
      "name": "Bill Gates",
      "cpf": "12585269354",
      "income": 3368.44,
      "birthDate": "1920-07-13T20:50:07.123450Z",
      "children": 2
    },
    {
      "id": 12,
      "name": "Dr Emmett Brown",
      "cpf": "12585269354",
      "income": 3024.44,
      "birthDate": "1920-07-13T20:50:07.123450Z",
      "children": 3
    }
  ],
  "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "pageNumber": 0,
    "pageSize": 6,
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": false,
  "totalPages": 3,
  "totalElements": 14,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "first": true,
  "number": 0,
  "numberOfElements": 6,
  "size": 6,
  "empty": false
}
```