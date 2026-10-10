## 📅 API de Agendamento de Horários

Uma API RESTful desenvolvida em Java e Spring Boot para gerenciar marcações de horários, conectando clientes a profissionais e serviços de forma eficiente.

### 🚀 Tecnologias Utilizadas
* **Linguagem:** Java 21
* **Framework:** Spring Boot (Web)
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** PostgreSQL
* **Gerenciador de Dependências:** Maven
* **Utilitários:** Lombok

### 🏗️ Arquitetura
O projeto foi estruturado seguindo o padrão de arquitetura em camadas, garantindo a separação de responsabilidades e facilitando a manutenção:
* **Controllers:** Gerenciamento das requisições HTTP e roteamento.
* **Services:** Isolamento e processamento das regras de negócio.
* **Repositories:** Comunicação e persistência de dados.
* **Entities:** Mapeamento objeto-relacional (ORM).

### ⚙️ Como Executar Localmente

1. Clone este repositório:
   ```bash
   git clone git@github.com:ocarllosmelo/agendamento-horarios.git

2. Configure o seu banco de dados no arquivo src/main/resources/application.properties:
   ```bash 
   spring.datasource.url=jdbc:postgresql://localhost:porta/seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   
3. Execute a aplicação usando o Maven Wrapper:
     ```bash 
    Bash

      ./mvnw spring-boot:run 

### 🔌 Endpoints da API

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/agendamentos` | Registra um novo agendamento |
| `GET` | `/agendamentos` | Retorna a lista de todos os agendamentos |
| `GET` | `/agendamentos/{id}` | Busca os detalhes de um agendamento específico |
| `PUT` | `/agendamentos/{id}` | Atualiza os dados de um agendamento existente |
| `DELETE` | `/agendamentos/{id}` | Remove um agendamento do sistema |

### Desenvolvido por: Carlos Melo