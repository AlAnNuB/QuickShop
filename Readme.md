> Um serviço simples e eficiente de gerenciamento de carrinho de compras, utilizando tecnologias modernas para oferecer performance e escalabilidade.

---

## 🔗 Índice

1. [Sobre o Projeto](#sobre-o-projeto)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
    - [Java 21](#java-21)
    - [Lombok](#lombok)
    - [Redis](#redis)
    - [MongoDB](#mongodb)
    - [Openfeign](#openfeign)
    - [Docker](#docker)
    - [API Externa](#api-externa)
3. [Funcionalidades](#funcionalidades)
4. [Como Rodar o Projeto](#como-rodar-o-projeto)
5. [License](#License)

---

## 📖 Sobre o Projeto

O projeto faz parte do módulo de Springboot do curso **java10x** é um serviço que gerencia um carrinho de compras simples, integrando dados de uma API externa para fornecer produtos disponíveis. Ele utiliza uma arquitetura eficiente que combina cache (Redis), banco de dados NoSQL (MongoDB), e contêineres (Docker), garantindo alta performance e escalabilidade.

### Principais Objetivos:
- Oferecer uma experiência fluida ao usuário.
- Minimizar chamadas desnecessárias à API externa através do cache.
- Facilitar o deploy em ambientes containerizados.

---

## 🛠 Tecnologias Utilizadas

O projeto foi desenvolvido com as seguintes tecnologias:

### Java 21
- A versão mais moderna da linguagem Java, focada em desempenho e funcionalidades aprimoradas.
- Saiba mais: [Documentação oficial do Java](https://openjdk.org/projects/jdk/21/).

### Lombok
- Reduz a verbosidade do código, automatizando a criação de getters, setters e construtores.
- Saiba mais: [Documentação oficial do Lombok](https://projectlombok.org/).

### Redis
- Um banco de dados em memória, utilizado como cache para melhorar a performance nas interações com a API externa.
- Saiba mais: [Introdução ao Redis](https://redis.io/docs/).

### MongoDB
- Banco de dados NoSQL, utilizado para armazenar as informações do carrinho de compras de maneira flexível.
- Saiba mais: [Documentação oficial do MongoDB](https://www.mongodb.com/docs/).


### OpenFeign
- Uma biblioteca que simplifica a integração com APIs externas, tornando a comunicação mais intuitiva e reduzindo a verbosidade do código.
- Saiba mais: [Documentação oficial do OpenFeign](https://github.com/OpenFeign/feign).

### Docker
- Ferramenta de containerização para criar ambientes consistentes e simplificados para deploy.
- Saiba mais: [Documentação oficial do Docker](https://docs.docker.com/).

### API Externa
- Integração com uma API que fornece a lista de produtos disponíveis para o carrinho.
- Saiba mais sobre integração com APIs: [Guia para trabalhar com APIs](https://www.postman.com/api-documentation/).

---

## ✨ Funcionalidades

- **Listar Produtos**: Gerencie os produtos do carrinho de forma simples.
- **Criar, Alterar, Pagar e Deletar**: Gerencie o carrinho de compras.
- **Cache Inteligente**: Reduz o tempo de resposta com dados armazenados no Redis.
- **Persistência com MongoDB**: Armazene os dados do carrinho com segurança e flexibilidade.
- **Integração com API Externa**: Produtos são carregados diretamente de uma API confiável.
- **Suporte Docker**: Implante o projeto rapidamente em qualquer ambiente.

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos

- **Docker** (ou instâncias de Redis e MongoDB configuradas localmente)
- **Java 21**
- **Maven** (ou use o wrapper mvnw)


### License

MIT License
