
# 🛠️ Projeto Rede Social Simples com Spring Boot

<div align="center">
  <strong>API RESTful para o gerenciamento de usuários, posts e comentários, com foco em escalabilidade e organização!</strong>
</div>

<br />

<div align="center">
  <img src="https://img.shields.io/badge/SpringBoot-3.4.4-brightgreen?style=for-the-badge&logo=spring"/>
  <img src="https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java"/>
  <img src="https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql"/>
  <img src="https://img.shields.io/badge/JPA-Hibernate-orange?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Swagger-Documentation-yellow?style=for-the-badge&logo=swagger"/>
</div>

---

## 📖 Índice

- [🔍 Visão Geral](#-visão-geral)
- [📦 Funcionalidades](#-funcionalidades)
- [✨ Diferenciais](#-diferenciais)
- [💻 Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [⚙️ Configuração do Ambiente](#-configuração-do-ambiente)
- [🧪 Testes e Popular Dados](#-testes-e-popular-dados)
- [🤝 Como Contribuir](#-como-contribuir)
- [📄 Licença](#-licença)

---

## 🔍 Visão Geral

Este projeto é uma **API simples de rede social** desenvolvida com **Spring Boot**, com foco em boas práticas, escalabilidade, modularização e clareza de código.

A API realiza o gerenciamento completo de **posts, usuários e comentários**, incluindo:
- Cadastro de usuários e posts;
- Relacionamentos entre entidades como `@ManyToOne`, `@OneToMany` (por exemplo, um post pode ter vários comentários);
- Registro e visualização de comentários feitos em posts;
- Exibição de informações de usuários responsáveis pelos posts e comentários.

---

## 📦 Funcionalidades

✔️ **Cadastro de Usuários** com informações como nome e email

✔️ **Cadastro de Posts** e seus conteúdos (título, corpo, autor)

✔️ **Cadastro de Comentários** nos posts com texto e autor

✔️ **Relacionamentos** entre `Usuários`, `Posts` e `Comentários`

✔️ **Requisições** `POST`, `GET`, `DELETE`, `PUT`, `PATCH` para interagir com a API

✔️ **Autenticação de Usuários** com base

---

## 📈 Diferenciais

⚙️ **Uso de JPA com Hibernate** para mapeamento automático das entidades
🔁 **Relacionamentos entre usuários, posts e comentários** tratados com `@OneToMany` e `@ManyToOne`
🧠 **Estrutura de recursos (posts e comentários)** bem definida para fácil manutenção e escalabilidade
🎯 **Respostas completas em JSON** com todos os dados necessários para integração com frontend ou testes via Postman

---

## 💻 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** 3.4.4
- **Spring Data JPA**
- **PostgreSQL** (ou H2 para ambiente de testes)
- **Hibernate**
- **Maven**

---

## ⚙️ Configuração do Ambiente

### Pré-requisitos

- **JDK 17** instalado
- **IDE** (IntelliJ, Eclipse, STS ou VS Code com suporte a Java)
- **PostgreSQL** (ou use o banco em memória H2 para testes)
- **Maven**

### Passos

1. **Clone o projeto**:
   ```bash
   git clone https://github.com/seu-usuario/rede-social-spring.git
   cd seu-projeto-rede-social
   ```

2. **Configure o banco de dados** no `application.properties` com as credenciais do PostgreSQL (ou use o `application-test.properties` para o banco H2).

3. **Execute a aplicação**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acesse os endpoints** via Postman ou front-end (porta padrão: `http://localhost:8080`).
  

5. Para **acessar a documentação** digite `http://localhost:8080/swagger-ui/index.html`, após rodar o comando clean install -DskipTests

---

## 🧪 Testes e Popular Dados

O projeto vem com uma classe **`TestConfig`** com o **profile `test`** que popula automaticamente:
- **Usuários** (`User`)
- **Posts** (`Post`)
- **Comentários** (`Comment`)

Ideal para testes e aprendizado sobre o funcionamento da API.

---

## 🤝 Como Contribuir

1. Faça um **fork** do projeto.
2. Crie uma **branch** com a sua feature: `git checkout -b minha-feature`.
3. **Commit** suas mudanças: `git commit -m 'feat: minha nova feature'`.
4. **Push** para sua branch: `git push origin minha-feature`.
5. Abra um **Pull Request**.

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Consulte [MIT License](https://mit-license.org/) para mais detalhes.

---

Desenvolvido com foco em **boas práticas**, **didática** e **organização**. Ideal para aprender e evoluir com **Spring Boot** e **JPA**!
