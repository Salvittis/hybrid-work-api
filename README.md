# HybridFlow - Sistema de Gestão de Trabalho Híbrido

## Visão Geral
O **HybridFlow** é uma solução corporativa desenvolvida para o desafio *Global Solution 2025*, visando otimizar a gestão de espaços de trabalho em modelos híbridos. A aplicação permite o agendamento de estações de trabalho, controle de capacidade e gestão de acesso de colaboradores.

## Arquitetura e Tecnologias
O projeto foi construído seguindo os princípios de arquitetura em camadas, utilizando:

*   **Java 17**
*   **Spring Boot 3.2.3**
*   **Spring Security** (com autenticação Stateless via JWT)
*   **H2 Database** (Banco de dados em memória para homologação)
*   **Maven** (Gerenciamento de dependências)

### Destaques Técnicos
*   **Segurança Granular**: Implementação de *Method Security* utilizando anotações `@PreAuthorize` para controle de acesso nos endpoints.
*   **Configuração Centralizada**: Uso de arquivos YAML para melhor legibilidade das configurações.
*   **Tratamento de Exceções**: Manipulação global de erros através de `@ControllerAdvice` e respostas padronizadas (`StandardError`).

## Instruções de Execução

### Pré-requisitos
*   JDK 17 instalado.
*   Maven instalado e configurado no PATH.

### Passo a Passo
1.  Clone o repositório para sua máquina local.
2.  Navegue até a raiz do projeto via terminal.
3.  Execute o comando de build e execução:
    ```bash
    mvn spring-boot:run
    ```
4.  A aplicação será iniciada na porta `8080`.

## Guia Completo de Testes da API 

Abaixo estão todos os cenários de teste possíveis, com exemplos de requisições.

### 1. Autenticação (`/auth`)

#### **1.1 Registrar um Gerente (Manager)**
*   **Método**: `POST`
*   **URL**: `/auth/register`
*   **Body**:
    ```json
    {
      "name": "Pedro Manager",
      "email": "pedro@company.com",
      "password": "password123",
      "profile": "MANAGER"
    }
    ```

#### **1.2 Registrar um Colaborador (Employee)**
*   **Método**: `POST`
*   **URL**: `/auth/register`
*   **Body**:
    ```json
    {
      "name": "Lipe Employee",
      "email": "lipe@company.com",
      "password": "password123",
      "profile": "EMPLOYEE"
    }
    ```

#### **1.3 Login**
*   **Método**: `POST`
*   **URL**: `/auth/login`
*   **Body**:
    ```json
    {
      "email": "pedro@company.com",
      "password": "password123"
    }
    ```
*   **Resposta**: Retorna um JSON com o `token`. **Copie este token** para usar nas próximas requisições (Header `Authorization: Bearer <token>`).

---

### 2. Estações de Trabalho (`/stations`)

#### **2.1 Criar Estação (Requer perfil MANAGER)**
*   **Método**: `POST`
*   **URL**: `/stations`
*   **Header**: `Authorization: Bearer <token_manager>`
*   **Body**:
    ```json
    {
      "code": "A-101",
      "hasMonitor": true,
      "isSilentZone": false
    }
    ```

#### **2.2 Listar Estações (Autenticado)**
*   **Método**: `GET`
*   **URL**: `/stations`
*   **Header**: `Authorization: Bearer <token>`

---

### 3. Reservas (`/bookings`)

#### **3.1 Criar Reserva (Requer perfil EMPLOYEE)**
*   **Método**: `POST`
*   **URL**: `/bookings`
*   **Header**: `Authorization: Bearer <token_employee>`
*   **Body**:
    ```json
    {
      "stationId": 1,
      "date": "2025-12-01"
    }
    ```

#### **3.2 Listar Reservas (Autenticado)**
*   **Método**: `GET`
*   **URL**: `/bookings`
*   **Header**: `Authorization: Bearer <token>`

## Banco de Dados
Para fins de desenvolvimento e teste, o banco H2 pode ser acessado via console web:
*   **URL**: `http://localhost:8080/h2-console`
*   **JDBC URL**: `jdbc:h2:mem:hybridflowdb`
*   **Usuário**: `admin`
*   **Senha**: `admin`

---
*Global Solution FIAP 2025 - The Future of Work*
Pedro Henrique Salvitti Habiro / RM88166
Filipe Prado Menezes / RM98765 
Cássio Eid Kobaysahi Yonetsuka / RM99678