# API To-Do List

Este projeto é uma API para gerenciar tarefas (To-Do List) desenvolvida em **Spring Boot**.

## Como Rodar Localmente

### 🛠️ Pré-requisitos

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)

### 📦 Instalação

1. Clone este repositório: git clone https://github.com/ArthurLorenzzo/Api-to-do-list.git
   
2. Acesse o diretorio do projeto: cd api-to-do-list

3. Compile o projeto: mvn clean install ou compile pela interface Ex: IntelliJ
   
4. execute a aplicação: mvn spring-boot:run ou execute pela interface Ex: IntelliJ

5. A API estará disponível em `http://localhost:8080`.

## 📡 Endpoints da API

### Tarefas

#### Criar uma tarefa
- **Método:** `POST`
- **Endpoint:** `/api/tarefas`
- **Body JSON:**  { "titulo": "Estudar Spring Boot", "descricao": "Ler a documentação oficial","status": "Pendente" }
- **Respostas:**
  
   `201 Created`: Tarefa foi criada com sucesso
  
   `400 Bad Request`: Requisição inválida
  

#### Buscar todas as tarefas
- **Método:** `GET`
- **Endpoint:** `/api/tarefas`
- **Respostas:**
  
   `200 OK`: Tarefas encontradas

#### Buscar uma tarefa por ID
- **Método:** `GET`
- **Endpoint:** `/api/tarefas/{id}`
- **Respostas:**
  
   `200 OK`: Tarefa encontrada

   `404 NOT FOUND`: Tarefa não encontrada

#### Atualizar o status de uma tarefa
- **Método:** `PUT`
- **Endpoint:** `/api/tarefas/{id}`
- **Body JSON:** { "status": "Concluida" }
- **Respostas:**
  
   `200 OK`: Status atualizado

   `400 BAD REQUEST`: Status inválido

   `404 NOT FOUND`: Tarefa não encontrada

#### Deletar uma tarefa
- **Método:** `DELETE`
- **Endpoint:** `/tarefas/{id}`
- **Respostas:**
  
   `204 NO CONTENT`: Tarefa deletada

   `404 NOT FOUND`: Tarefa não encontrada

## 🛠️ Tecnologias Utilizadas

- **Spring Boot**
- **JPA**
- **H2**
- **Maven**
- **JUnit**
