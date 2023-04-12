# Tweetero API - API para rede social de microblog

### Aplicação back-end para rede social desenvolvida com Spring Framework e H2 Database.

### Requisitos: 
  * Java 17

### URL:
 O *endpoint* do serviço estará disponível em http://localhost:8080


### Rotas e métodos da API : 

Metódos **POST**

`/api/sign-up`

Rota para Login recebe os parametros `username` e `avatar` no **body** da requisição. O campo `avatar` deve uma url com uma imagem com no max 256 caracteres

```
POST

    /api/sign-up

      parâmetros:
       body {
        username: string,
        avatar: string,
      }

```

`/api/tweets`

Rota para fazer uma postagem. Recebe `text` sendo uma *String* no **body** da requisição. E no **headers** deve receber `User` com o username do usuário.

```
POST

    /api/tweets

      parâmetros:
       body {
        text: string,
      }
      headers{
        User: string,
      }

```

Metódos **GET**

`/api/tweets?page=0`

Retorna os ultimos tweets postados com paginação. O param `page` deve ser um inteiro.

```
GET

    /api/tweets?page=0

    Retorno:
      {content: 
          [{
            username: string,
            avatar: string,
            text: string, 
          }]
      }

```

`/api/tweets/{username}`

Retorna uma lista dos tweets postados pelo usuário com nome igual `username`.

```
GET

    /api/tweets/username

    Retorno:
      [{
        username: string,
        avatar: string,
        text: string,
      }]
      

```

**Deploy:**

**Front-end:**

**Deploy Front-end:**
