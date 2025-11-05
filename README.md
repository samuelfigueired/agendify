<h1 align="center">🧠 Agendify — Sistema de Agendamento Inteligente</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-red?logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring_Boot-3.5.6-brightgreen?logo=springboot" />
  <img src="https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql" />
  <img src="https://img.shields.io/badge/License-MIT-lightgrey" />
</p>

---

## 🚀 Sobre o Projeto

O **Agendify** é um projeto pessoal em desenvolvimento, criado com o objetivo de **aprimorar minhas habilidades como desenvolvedor** e aplicar boas práticas de **arquitetura limpa (Clean Architecture)**, separação de responsabilidades e uso de tecnologias modernas do ecossistema **Spring Boot**.

O foco é construir um **sistema de agendamento inteligente** para profissionais autônomos, com autenticação, controle de usuários e interface de API documentada.

---

## ⚙️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **Spring Security (Basic Auth)**
- **Swagger (Springdoc OpenAPI)**
- **MapStruct**
- **Flyway**
- **PostgreSQL**
- **Lombok**

---

## 🏗️ Estrutura do Projeto

O projeto segue uma estrutura modular e limpa, organizada da seguinte forma:

com.agendify
├── core
│ ├── config → Configurações globais (Security, Swagger, etc.)
│ ├── exception → Exceções personalizadas
│ ├── mapper → BaseMapper genérico
│ └── util → Utilitários e constantes
│
└── agendamento
├── controller → Controladores REST
├── dto → DTOs de entrada e saída
├── model → Entidades (JPA)
├── repository → Interfaces do Spring Data
├── service → Regras de negócio
└── mapper → Implementações específicas de mapeamento

---

## 🔐 Autenticação e Segurança

O **Agendify** utiliza autenticação **HTTP Basic Auth**, com usuários em memória configurados via `SecurityConfig`.

**Credenciais padrão:**

## 🔐 Autenticação e Segurança

Atualmente, o projeto utiliza **autenticação básica (HTTP Basic Auth)** com usuários configurados em memória através do `SecurityConfig`.

**Credenciais padrão:**
Usuário: admin
Senha: 1234



🔒 O próximo passo será evoluir essa autenticação para **JWT** e integração com a entidade `Usuário`.

---

## 📚 Endpoints Principais

**Swagger UI:**  
👉 [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

**Endpoints REST:**
GET /api/agendamentos
POST /api/agendamentos


Exemplo de `POST`:
json
{
  "cliente": "Samuel",
  "servico": "Agendamento",
  "dataHora": "2025-11-05T15:20:00Z",
  "status": "Ativo"
}
## 🧩 Próximos Passos

- [x] Criar estrutura base do projeto  
- [x] Implementar BaseMapper genérico  
- [x] Configurar Spring Security e Swagger  
- [ ] Criar entidade **Usuário**  
- [ ] Implementar autenticação com **JWT**  
- [ ] Adicionar testes automatizados  
- [ ] Configurar **Docker Compose** (App + DB)  
- [ ] Fazer deploy na **nuvem (Render/Railway)**  

---

## 💡 Objetivo

Este projeto é um **laboratório de aprendizado e evolução profissional**, explorando boas práticas de backend moderno, arquitetura limpa e design modular.  
A cada etapa, pretendo documentar os avanços no **GitHub** e compartilhar aprendizados no **LinkedIn**.

---

## 🧑‍💻 Autor

**Samuel Figueiredo**  
📍 PUC Minas — Sistemas de Informação  
🔗 [LinkedIn](https://linkedin.com/in/samuelfigueired)  
💻 [GitHub](https://github.com/samuelfigueired)

---

## 📸 Prévia

<img width="800" src="https://github.com/user-attachments/assets/20eaf0c8-b0da-454e-9e09-2e5934b58afa" alt="Swagger UI">
<img width="800" src="https://github.com/user-attachments/assets/deb802a6-5e88-4914-ab3a-7cf6c56cfeda" alt="Postman Preview">

---

<p align="center">
  Feito com 💚 por <b>Samuel Figueiredo</b> — Aprendizado contínuo em Java & Spring 🚀
</p>
