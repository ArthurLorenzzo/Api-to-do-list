# API To-Do List

Este projeto é uma API para gerenciar tarefas (To-Do List) desenvolvida em **Spring Boot**.

## 🚀 Como Rodar Localmente

### 🛠️ Pré-requisitos

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)

### 📦 Instalação

1. Clone este repositório:
   \`\`\`sh
   git clone https://github.com/seu-usuario/api-to-do-list.git
   cd api-to-do-list
   \`\`\`

2. Compile e execute a aplicação:
   \`\`\`sh
   mvn spring-boot:run
   \`\`\`

3. A API estará disponível em `http://localhost:8080`.

## 📡 Endpoints da API

### 📌 Tarefas

#### Criar uma tarefa
- **Método:** `POST`
- **Endpoint:** `/api/tarefas`
- **Body JSON:**
  \`\`\`json
  {
    "titulo": "Estudar Spring Boot",
    "descricao": "Ler a documentação oficial",
    "status": "Pendente"
  }
  \`\`\`

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
  \`\`\`json
  {
    "status": "Concluida"
  }
  \`\`\`

#### Deletar uma tarefa
- **Método:** `DELETE`
- **Endpoint:** `/tarefas/{id}`

## 🛠️ Tecnologias Utilizadas

- **Spring Boot**
- **JPA**
- **H2**
- **Maven**
- **JUnit**
