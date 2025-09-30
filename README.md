# CNAB ParseFlow 
<div>
<img src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white"/> <img src= "https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white"/> <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white"/> <img src="https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E"/> 
</div>

Este projeto foi desenvolvido como um **exercício/desafio de prática** com Java, Spring Boot, JPA e JavaScript.  
O objetivo do desafio é processar o arquivo CNAB.txt, tratar os dados(transações) do arquivo e salvar em um banco de dados com integração entre frontend e backend.

- [Informações do Desafio Aqui](https://github.com/ByCodersTec/desafio.net)
---

## 💻 Tecnologias usadas

- Java 17 + Spring Boot
- JPA
- HTML, CSS, JavaScript
- Maven

---

## 📁 Estrutura do projeto

- Back-end utilizei o padrão MVC por ser o padrão que estou mais familiarizado.
- Frontend básico .html, style.css e .js
---

## ⚙️ Funcionalidades

1. Upload de arquivo CNAB via frontend
2. Processamento e armazenamento das transações no banco
3. Listagem das transações `GET /cnab/listar-transacao` (Não disponível no front)
4. Limpeza das transações `DELETE /cnab/limpar` (Não disponível no front)

