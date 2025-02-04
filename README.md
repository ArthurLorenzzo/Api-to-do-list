# API To-Do List

Este projeto é uma API para gerenciar tarefas (To-Do List) desenvolvida em **Spring Boot**.

## Como Rodar Localmente

### 🛠️ Pré-requisitos

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)

### 📦 Instalação

1. Clone este repositório: git clone https://github.com/ArthurLorenzzo/Api-to-do-list.git
   
2. Acesse o diretorio do projeto: cd api-to-do-list
   
3. Compile e execute a aplicação: mvn spring-boot:run

3. A API estará disponível em `http://localhost:8080`.

## 📡 Endpoints da API

### 📌 Tarefas

#### Criar uma tarefa
- **Método:** `POST`
- **Endpoint:** `/api/tarefas`
- **Body JSON:**
 
  {
    "titulo": "Estudar Spring Boot",
    "descricao": "Ler a documentação oficial",
    "status": "Pendente"
  }
  

#### Buscar todas as tarefas
- **Método:** `GET`
- **Endpoint:** `/api/tarefas`

#### Buscar uma tarefa por ID
- **Método:** `GET`
- **Endpoint:** `/api/tarefas/{id}`

#### Atualizar o status de uma tarefa
- **Método:** `PUT`
- **Endpoint:** `/api/tarefas/{id}`
- **Body JSON:**
 
  {
    "status": "Concluida"
  }


#### Deletar uma tarefa
- **Método:** `DELETE`
- **Endpoint:** `/tarefas/{id}`

## 🛠️ Tecnologias Utilizadas

- **Spring Boot**
- **JPA**
- **H2**
- **Maven**
- **JUnit**
