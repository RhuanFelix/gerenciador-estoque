-- drop table Produto, Categoria

CREATE TABLE Categoria ( 
 id SERIAL PRIMARY KEY,  
 nome VARCHAR(150) UNIQUE NOT NULL,  
 descricao VARCHAR(255) 
);

CREATE TABLE Produto ( 
 id SERIAL PRIMARY KEY,  
 nome VARCHAR(100) NOT NULL,
 marca VARCHAR(100) NOT NULL,
 quantidade INT NOT NULL,  
 preco DECIMAL NOT NULL,  
 id_categoria INT NOT NULL,
 FOREIGN KEY (id_categoria) REFERENCES Categoria(id)
); 

CREATE TABLE metricas_categoria (
    categoria VARCHAR(255) PRIMARY KEY,
    valor_total DECIMAL
);