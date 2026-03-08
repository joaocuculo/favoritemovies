# 🎬 Favorite Movies API

API REST para gerenciamento de filmes favoritos. O projeto permite que usuários se cadastrem, façam login e gerenciem sua lista de filmes favoritos, consumindo dados de filmes diretamente da [OMDb API](https://www.omdbapi.com/).

> Projeto desenvolvido com o objetivo de praticar e consolidar conhecimentos em desenvolvimento backend com Java e Spring Boot, aplicando boas práticas de arquitetura, segurança e documentação de APIs.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 4**
- **Spring Security** com autenticação via **JWT**
- **Spring Data JPA** + **PostgreSQL**
- **WebClient** para consumo da OMDb API
- **Swagger / OpenAPI 3** para documentação interativa

---

## 📦 Funcionalidades

- Cadastro e autenticação de usuários
- Busca de filmes pelo título (integração com OMDb API)
- Busca de detalhes de um filme pelo IMDb ID
- Favoritar e desfavoritar filmes
- Listagem de filmes favoritos com paginação
- Gerenciamento de usuários (listagem, edição e exclusão)
- Controle de acesso por roles: `USER` e `ADMIN`

---

## ⚙️ Como Rodar Localmente

### Pré-requisitos

- Java 21
- Maven
- PostgreSQL rodando localmente
- Chave de API da [OMDb API](https://www.omdbapi.com/apikey.aspx) (gratuita)

### Configuração

Crie um arquivo `application-dev.properties` dentro de `src/main/resources/` com as seguintes variáveis:

```properties
## DB
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true

spring.datasource.url=jdbc:postgresql://localhost:5432/favorite_movies
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true

## API
omdb.api.key=OMDB_API_KEY

## JWT Authentication
api.security.token.secret=SECRET_JWT

# Swagger
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
```

> ⚠️ Nunca suba o arquivo `application-dev.properties` com dados reais para o repositório. Adicione-o ao `.gitignore`.

### Executando

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/favoritemovies.git
cd favoritemovies

# Execute com Maven
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

A documentação Swagger estará disponível em `http://localhost:8080/swagger-ui/index.html`.

---

## 👤 Usuário de Teste

Ao subir a aplicação, um usuário **ADMIN** é inserido automaticamente no banco via `data.sql`:

| Campo | Valor           |
|-------|-----------------|
| Nome | Pedro           |
| E-mail | pedro@email.com |
| Senha | 1234            |
| Role | ADMIN           |

> ⚠️ Esse usuário existe apenas para fins de demonstração e desenvolvimento. Em produção, não utilize dados fixos no banco.

---

## 🔐 Como Autenticar no Swagger

1. Acesse `http://localhost:8080/swagger-ui/index.html`
2. Use o endpoint `POST /auth/login` com as credenciais desejadas:

```json
{
  "email": "pedro@email.com",
  "password": "1234"
}
```

3. Copie o token JWT retornado no campo `token`
4. Clique no botão **Authorize** 🔒 no topo da página
5. Cole o token no campo e confirme
6. Pronto! Todos os endpoints autenticados já estarão acessíveis

---

## 📡 Endpoints

### 🔑 Autenticação — `/auth`

| Método | Endpoint | Descrição | Acesso |
|--------|----------|-----------|--------|
| POST | `/auth/login` | Realiza login e retorna o token JWT | Público |
| POST | `/auth/register` | Cadastra um novo usuário | Público |

#### Exemplo — Login

**Request:**
```json
POST /auth/login
{
  "email": "pedro@email.com",
  "password": "1234"
}
```

**Response `200`:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

#### Exemplo — Cadastro

**Request:**
```json
POST /auth/register
{
  "name": "João",
  "email": "joao@email.com",
  "password": "senha123"
}
```

**Response `201`:**
```json
{
  "id": 2,
  "name": "João",
  "email": "joao@email.com"
}
```

---

### 🎥 Filmes — `/movies`

| Método | Endpoint | Descrição | Acesso |
|--------|----------|-----------|--------|
| GET | `/movies?search={titulo}` | Busca filmes pelo título | Autenticado |
| GET | `/movies/{imdbId}` | Retorna detalhes de um filme | Autenticado |

#### Exemplo — Busca por título

**Request:**
```
GET /movies?search=batman&page=1
```

**Response `200`:**
```json
{
  "movies": [
    {
      "title": "Batman Begins",
      "year": "2005",
      "imdbID": "tt0372784",
      "type": "movie",
      "poster": "https://..."
    }
  ],
  "page": 1,
  "totalResults": 312,
  "totalPages": 32
}
```

---

#### Exemplo — Busca por IMDb ID

**Request:**
```
GET /movies/tt0372784
```

**Response `200`:**
```json
{
  "imdbId": "tt0372784",
  "title": "Batman Begins",
  "year": "2005",
  "rated": "PG-13",
  "runtime": "140 min",
  "genre": "Action, Adventure",
  "director": "Christopher Nolan",
  "imdbRating": "8.2",
  "boxOffice": "$206,852,432",
  "plot": "After witnessing his parents' brutal murder..."
}
```

---

### ⭐ Favoritos — `/favorites`

| Método | Endpoint | Descrição | Acesso |
|--------|----------|-----------|--------|
| GET | `/favorites` | Lista os favoritos do usuário autenticado | Autenticado |
| POST | `/favorites` | Adiciona um filme aos favoritos | Autenticado |
| DELETE | `/favorites/{favoriteId}` | Remove um filme dos favoritos | Autenticado |

#### Exemplo — Adicionar favorito

**Request:**
```json
POST /favorites
{
  "movieImdbId": "tt0372784"
}
```

**Response `201`:**
```json
{
  "id": 1,
  "imdbId": "tt0372784",
  "title": "Batman Begins",
  "poster": "https://...",
  "imdbRating": 8.2,
  "favoritedAt": "2026-03-08T14:00:00Z"
}
```

---

### 👥 Usuários — `/users`

| Método | Endpoint | Descrição | Acesso |
|--------|----------|-----------|--------|
| GET | `/users` | Lista todos os usuários com paginação | ADMIN |
| GET | `/users/{id}` | Retorna um usuário pelo ID | Autenticado |
| PUT | `/users/{id}` | Atualiza dados do usuário | Próprio usuário ou ADMIN |
| DELETE | `/users/{id}` | Remove um usuário | ADMIN |

---

## 🗂️ Estrutura do Projeto

```
src/main/java/com/joaocuculo/favoritemovies/
├── client/          # Integração com a OMDb API (WebClient)
├── config/          # Configurações gerais (WebClient bean)
├── controllers/     # Camada de entrada — endpoints REST
├── dto/             # Objetos de transferência de dados (Records)
├── entities/        # Entidades JPA (User, Movie, Favorite)
├── exceptions/      # Exceções customizadas de domínio
├── infra/           # Handler global de exceções e StandardError
├── repositories/    # Interfaces JPA (Spring Data)
├── security/        # Configuração de segurança, JWT e filtro
└── services/        # Regras de negócio
```