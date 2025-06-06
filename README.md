# Guia de Teste de Autenticação JWT com Insomnia

Este guia detalha como testar a implementação de autenticação JWT no projeto Spring Boot `nexusResponseTeste` utilizando o Insomnia.

## Pré-requisitos

*   Insomnia instalado.
*   O projeto `nexusResponseTeste` deve estar em execução. Para iniciar o projeto, navegue até a pasta raiz do projeto (`/home/ubuntu/nexusResponseTeste`) no terminal e execute o comando:
    ```bash
    mvn spring-boot:run
    ```

## 1. Registrar um Novo Usuário

Primeiro, você precisa registrar um novo usuário que será usado para autenticação.

### Requisição

*   **Método:** `POST`
*   **URL:** `http://localhost:8080/auth/register`
*   **Headers:**
    *   `Content-Type: application/json`
*   **Body (JSON):**
    ```json
    {
        "email": "seu_email@example.com",
        "senha": "sua_senha_segura",
        "nome": "Seu Nome",
        "cpf": "12345678901",
        "papel": "USER"
    }
    ```

### Exemplo no Insomnia

1.  Crie uma nova requisição `POST`.
2.  Defina a URL como `http://localhost:8080/auth/register`.
3.  Na aba `Headers`, adicione `Content-Type` com o valor `application/json`.
4.  Na aba `Body`, selecione `JSON` e insira o JSON acima, substituindo `seu_email@example.com`, `sua_senha_segura`, `Seu Nome` e `12345678901` pelos seus dados.
5.  Envie a requisição.

### Resposta Esperada

*   **Status:** `200 OK` (se o registro for bem-sucedido)
*   **Status:** `400 Bad Request` (se o usuário já existir ou houver dados inválidos)

## 2. Fazer Login e Obter o Token JWT

Após registrar o usuário, você pode fazer login para obter o token JWT.

### Requisição

*   **Método:** `POST`
*   **URL:** `http://localhost:8080/auth/login`
*   **Headers:**
    *   `Content-Type: application/json`
*   **Body (JSON):**
    ```json
    {
        "email": "seu_email@example.com",
        "senha": "sua_senha_segura"
    }
    ```

### Exemplo no Insomnia

1.  Crie uma nova requisição `POST`.
2.  Defina a URL como `http://localhost:8080/auth/login`.
3.  Na aba `Headers`, adicione `Content-Type` com o valor `application/json`.
4.  Na aba `Body`, selecione `JSON` e insira o JSON acima com as credenciais do usuário que você registrou.
5.  Envie a requisição.

### Resposta Esperada

*   **Status:** `200 OK`
*   **Body (JSON):**
    ```json
    {
        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    }
    ```
    Copie o valor do `token`. Você precisará dele para as próximas requisições.

## 3. Acessar Endpoints Protegidos com o Token JWT

Agora você pode usar o token JWT para acessar os endpoints que exigem autenticação.

### Requisição (Exemplo: Acessando `/environmental-nodes`)

*   **Método:** `GET` (ou qualquer outro método para um endpoint protegido)
*   **URL:** `http://localhost:8080/environmental-nodes` (ou qualquer outro endpoint protegido)
*   **Headers:**
    *   `Authorization: Bearer SEU_TOKEN_JWT`

### Exemplo no Insomnia

1.  Crie uma nova requisição (por exemplo, `GET`).
2.  Defina a URL para um endpoint protegido, como `http://localhost:8080/environmental-nodes`.
3.  Na aba `Headers`, adicione `Authorization` com o valor `Bearer SEU_TOKEN_JWT`, substituindo `SEU_TOKEN_JWT` pelo token que você copiou na etapa anterior.
4.  Envie a requisição.

### Resposta Esperada

*   **Status:** `200 OK` (se a autenticação for bem-sucedida e a requisição for válida)
*   **Status:** `403 Forbidden` (se o token for inválido ou ausente)

Com esses passos, você poderá testar a funcionalidade de autenticação JWT no seu projeto Spring Boot.

