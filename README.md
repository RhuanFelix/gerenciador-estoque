# Gerenciador de Estoque

Este projeto é uma API REST de gerenciamento de estoque desenvolvido com **Java** e **Spring Boot** e faz parte de uma atividade da disciplina de Banco de Dados II, este projeto está em sua fase inicial. A aplicação permite manipular um banco de dados PostgreSQL por meio de requisições HTTP.

## Funcionalidades

- Adicionar, listar, atualizar e deletar categorias;
- Pesquisar categorias pelo ID;
- Pesquisar categorias pelo nome;
- Adicionar, listar, atualizar, e deletar produtos;
- Pesquisar produtos pelo ID.

## Tecnologias utilizadas

- Java 21;
- Spring Boot;
- Spring Data JPA;
- Spring Web;
- SpringDoc OpenAPI;
- PostgreSQL;
- Maven

## Arquitetura do projeto

O projeto segue a arquitetura em camadas:

- **Model**: entidades JPA que representam as tabelas do banco;
- **Repository**: interfaces que acessam os dados via Spring Data JPA;
- **Service**: camada de lógica de negócio;
- **Controller**: endpoints REST para comunicação com o front-end ou ferramentas externas que servem como cliente HTTP como Postman.

## Estrutura do Banco de Dados

O banco é composto pelas seguintes tabelas:

- Categoria;
- Produto.

## Como executar o projeto

### 1. Pré-requisitos

- Java 21 instalado;
- PostgreSQL rodando localmente;
- Maven instalado.

### 2. Clonando o projeto no seu computador

- Abra o seu terminal e execute o comando: ```git clone https://github.com/RhuanFelix/gerenciador-estoque.git```;
- Abra o projeto clonado na sua IDE de preferência.

### 3. Configuração do banco de dados

- Crie um banco de dados no PostgreSQL com o nome: ```gerenciador_estoque```;
- Execute o script SQL localizando em [gerenciador_estoque.sql](./sql/gerenciador_estoque.sql) para criar as tabelas necessárias.

### 4. Configuração de conexão

Para configurar a conexão com o banco de dados, vá até o arquivo [application.properties](api/src/main/resources/resources/application.properties) e substitua os campos com os seus dados reais.

### 5. Execução

- Com o projeto aberto na IDE, abra o terminal e execute o comando ```./mvnw spring-boot:run``` ou se preferir, na sua IDE, vá para o arquivo [GerenciamentoEstoqueApplication.java](api/src/main/java/com/tsi/gerenciamento_estoque/GerenciamentoEstoqueApplication.java) e clique no botão de "Run".
- No seu navegador, coloque a seguinte URL: ```http://localhost:8080/swagger-ui/index.html```.

## Breve explicação do que é usado

Para quem não tem uma familiaridade com Spring Boot, você pode ir para o arquivo [Explicando_o_Spring_Boot.md](./Explicando_o_Spring_Boot.md) em que nele explica o que foi utilizado neste projeto.