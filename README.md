# Microservice Star Wars 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/ariellopes94/star-wars/blob/main/LICENSE) 


# Sobre o projeto

Microservice Star Wars é uma API desenvolvida em Java 11 e Spring Boot, construída para se comunicar com API publica **SWAPI**.


Esse microservice fornece uma interface REST que pode ser chamada via HTTP. O serviço buscará informações de um banco de dados. Em outros casos,o serviço chamará uma API STAR WARS externa via HTTP para buscar e exibir planeta e quantidade de aparições em filmes, uma lista de filmes em que o planeta já apareceu.

![Mobile 1](https://raw.githubusercontent.com/ariellopes94/imagens-para-readme/master/Star%20Wars/mapeamento%20estrutura%20projeto.png)  <br />
Figura 1: Estrutura de alto nível do sistema de microsserviço
 <br /> <br />


## Documentação desenvolvida com Springdoc-openapi-ui
![Mobile 2](https://raw.githubusercontent.com/ariellopes94/imagens-para-readme/master/Star%20Wars/star-wars-gif.gif)
 https://starwarsapiariellopes2021.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

# Tecnologias utilizadas
## Back end
- Java 11
- Spring Boot
- Maven
- Mongodb

## Implantação em produção
- Back end: Heroku

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/ariellopes94/star-wars.git
# entrar na pasta do projeto back end
cd backend
# executar o projeto
./mvnw spring-boot:run
```

# Autor

Ariel Lopes de Souza

https://www.linkedin.com/in/ariel-lopes-de-souza-50321065/
