<h1 align="center"> Tweteroo - Springboot api</h1>
<p align="center">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt:"Java"/>
  <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt:"Spring"/>
   <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt:"postgres"/>
</p>

<p align="center">
Este é um API desenvolvido com Java|SpringBoot + PostgreSQL para cadastro de usuários, onde os usuários podem criar tweets.
</p>

## Pré-requisitos
Certifique-se de ter as seguintes ferramentas instaladas em sua máquina antes de começar:

- Java 17
- PostgreSQL

## Rotas


<details>
  <summary>POST /users</summary>
  
- **Endpoint:** `POST /users`
- **Descrição:** Cadastra um novo usuário      
- **Resposta:** Retorna um objeto de usuário

## Request Body: 

 ```bash
  {
    "username": "bobesponja",
	"avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
  ```
## Response:
 status: 201 (CREATED)
  ```bash
 
  {
    "id": 1,
    "username": "bobesponja",
	"avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
  ```
</details>

<details>
  <summary>POST /tweets</summary>
  
- **Endpoint:** `POST /tweets`
- **Descrição:** Cadastra um novo TWEET   
- **Resposta:** Retorna um objeto tweet com informações do usuário.

## Request Body: 

 ```bash
 {
"userId": 1,
"text": "Olá mundo!"
 }
  ```
## Response:
 status: 201 (CREATED)
  ```bash
 {
  "id": 20,
  "text": "Olá mundo",
  "user": {
    "id": 1,
    "username": "bobesponja",
    "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
}
  ```
</details>

<details>
  <summary>GET /tweets</summary>
  
- **Endpoint:** `GET /TWEETS`
- **Descrição:** Mostra todos os tweets.  
- **Resposta:** Retorna um array de objetos tweets



## Response:
 status: 200 (OK)
  ```bash
 
 [
  {
    "id": 20,
    "text": "meu primeiro tweet",
    "user": {
      "id": 1,
      "username": "bobesponja",
      "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
  ,
  {
    "id": 21,
    "text": "eu moro numa pedra",
    "user": {
      "id": 2,
      "username": "patrick",
      "avatar": "https://gartic.com.br/imgs/mural/te/tettyzinhah15/patrick-estrela.png"
  }
  ,
  {
    "id": 22,
    "text": "eu amo hambúrguer de siri",
    "user": {
      "id": 1,
      "username": "bobesponja",
      "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
]
  ```
</details>

<details>
  <summary>GET /tweets/user/:{userId}</summary>
  
- **Endpoint:** `GET /tweets/user/:userId`
- **Descrição:** Mostra todos os tweets de determinado usuário.  
- **Resposta:** Retorna um array de objetos tweets



## Response:
 status: 200 (OK)
  ```bash
 
 [
  {
    "id": 20,
    "text": "meu primeiro tweet",
    "user": {
      "id": 1,
      "username": "bobesponja",
      "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
  ,
  {
    "id": 21,
    "text": "eu moro numa pedra",
    "user": {
      "id": 2,
      "username": "patrick",
      "avatar": "https://gartic.com.br/imgs/mural/te/tettyzinhah15/patrick-estrela.png"
  }
  ,
  {
    "id": 22,
    "text": "eu amo hambúrguer de siri",
    "user": {
      "id": 1,
      "username": "bobesponja",
      "avatar": "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
  }
]
  ```
</details>
