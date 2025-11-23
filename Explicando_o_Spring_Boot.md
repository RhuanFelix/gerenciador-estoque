# Conceitos Utilizados no Projeto com Spring Boot

Este documento tem como objetivo explicar os recursos do Spring Boot utilizados no projeto. 

---

## 1. Entidades e Mapeamento com JPA

No Spring Boot, trabalhamos com o **JPA (Java Persistence API)** para mapear classes Java em tabelas do banco de dados.

- **@Entity**: Indica que uma classe representa uma entidade no banco de dados.
- **@Id**: Define o atributo que será a chave primária da tabela.
- **@GeneratedValue**: Configura a geração automática do valor da chave primária (ex.: GenerationType.IDENTITY indica ao JPA/Hibernate que o banco que se responsabiliza de gerar a chave primária).
- **@Column**: Permite configurar detalhes da coluna no banco, como nome (name), tamanho (length) ou se pode ser nula (nullable).
- **@ManyToOne**: Define um relacionamento de muitos para um entre entidades (ex.: muitos produtos para uma categoria).
- **@JoinColumn**: Especifica a coluna que será usada como chave estrangeira em um relacionamento.

Essas anotações são fundamentais para que o Spring Boot saiba como traduzir objetos Java em registros no banco.

---

## 2. Repositórios com JpaRepository

O **JpaRepository** é uma interface que fornece métodos prontos para operações no banco de dados, como salvar (save), buscar (find), atualizar (por meio de setters) e deletar (delete) registros.  
Ao criar uma interface que estende `JpaRepository`, não é necessário escrever SQL manualmente para operações básicas.

Exemplo:
```java
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
```

---

## 3. Camada de Serviço
A camada de serviço concentra a lógica de negócio da aplicação.

- **@Service**: Indica que uma classe é um componente de serviço, responsável por regras de negócio e interações entre repositórios e controladores.
- **@Autowired**: Permite a injeção automática de dependências, ou seja, o Spring Boot cria e fornece instâncias de classes necessárias sem que seja preciso instanciá-las manualmente.

---

## 4. Controladores REST
Os controladores são responsáveis por expor a aplicação através de endpoints HTTP.

- **@RestController**: Define que a classe é um controlador REST, capaz de receber requisições e retornar respostas em formato JSON.
- **@GetMapping**: Mapeia requisições HTTP do tipo GET (usadas para buscar informações).
- **@PostMapping**: Mapeia requisições HTTP do tipo POST (usadas para criar novos registros).
- **@PutMapping**: Mapeia requisições HTTP do tipo PUT (usadas para atualizar registros existentes).
- **@DeleteMapping**: Mapeia requisições HTTP do tipo DELETE (usadas para remover registros).

---

## 5. Manipulação de Dados nas Requisições
Para que os dados enviados ou recebidos nas requisições sejam tratados corretamente, utilizamos algumas anotações adicionais:

- **@PathVariable**: Captura valores diretamente da URL. Exemplo: /clientes/{id} → o {id} é obtido com @PathVariable.
- **@RequestBody**: Indica que os dados enviados no corpo da requisição (em JSON) devem ser convertidos para um objeto Java.
