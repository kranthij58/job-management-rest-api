# 🚀 Job Management REST API with Spring Security

A robust Job Management System built using **Spring Boot**, **Spring Data JPA**, **Spring Security**, and **MySQL**.

The application provides complete CRUD operations for managing jobs along with secure authentication using Spring Security, JWT, and BCrypt password encryption.

# 📌 Tech Stack

* Java 21
* Spring Boot 4.x
* Spring Web MVC
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* Hibernate
* MySQL
* Lombok
* Maven
* Postman

---

# 🏗️ Architecture

This project follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository (JPA)
    ↓
MySQL Database
```

### Layers

#### Controller Layer

Handles HTTP requests and responses.

#### Service Layer

Contains business logic and application rules.

#### Repository Layer

Interacts with the database using Spring Data JPA.

#### Entity Layer

Maps Java objects to database tables.

---

# 🔥 Features

## Job Management

✅ Create a Job

✅ Retrieve all Jobs

✅ Retrieve Job by ID

✅ Update a Job

✅ Delete a Job

✅ Search Jobs by Keyword

---

## Security Features

✅ Spring Security Integration

✅ Basic Authentication

✅ Custom UserDetailsService

✅ Custom UserPrincipal Implementation

✅ BCrypt Password Encryption

✅ JWT Authentication

✅ User Registration Endpoint

✅ Stateless Session Management

---

## Database Features

✅ MySQL Integration

✅ Spring Data JPA Repositories

✅ Hibernate ORM

✅ Automatic Table Generation

---

# 🗄️ Database Configuration

Configure MySQL credentials inside:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/job_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> ⚠️ Never commit database credentials to GitHub.

---

# 📂 Project Structure

```text
src
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── config
 └── JobApp2Application
```

---

# 🔐 Authentication

The application supports **both** Basic Authentication and JWT Authentication.
 
---

## Register a User

### Endpoint

```http
POST /register-user
```

### Request Body

```json
{
  "username": "kranthi",
  "password": "1234"
}
```

### Response

```json
{
  "id": 1,
  "username": "kranthi"
}
```
 
---

## Option 1: Basic Authentication

After registering a user, use Basic Authentication directly.

### Example

```http
GET /jobs
```

Authorization:

```text
Username: kranthi
Password: 1234
```
 
---

## Option 2: JWT Authentication

### Login Endpoint

```http
POST /login
```

### Request Body

```json
{
  "username": "kranthi",
  "password": "1234"
}
```

### Response

```text
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaGF2eWEiLCJleHAiOjE3ODE3NjA4MzIsImlhdCI6MTc4MTc2MDIzMn0.Xbrd1uRnG_xrsSDKTo0o_8AauSjJR6VJFJ7xawXbeQ0
```

### Using the Token

Add the token to the `Authorization` header on subsequent requests:

```text
Authorization: Bearer <token>
```

### Example

```http
GET /jobs
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiaGF2eWEiLCJleHAiOjE3ODE3NjA4MzIsImlhdCI6MTc4MTc2MDIzMn0.Xbrd1uRnG_xrsSDKTo0o_8AauSjJR6VJFJ7xawXbeQ0
```
 
---

### How JWT Works in This Project

* On login, the server generates a signed JWT containing the username (`sub`), issued-at (`iat`), and expiry (`exp`) claims.
* The token is signed using **HMAC SHA-256 (HS256)**.
* A custom JWT filter intercepts incoming requests, validates the token's signature and expiry, and authenticates the user before the request reaches the controller.
* This makes the API **stateless** — no session is stored on the server, and every request is authenticated independently using the token.
* Once the token expires, the client must log in again via `/login` to get a fresh one.
---

# 📌 Job API Endpoints

## Get All Jobs

```http
GET /jobs
```

---

## Get Job By ID

```http
GET /jobs/{postId}
```

---

## Create Job

```http
POST /jobs
```

Example Request:

```json
{
  "postId": "8",
  "postProfile": "Java Developer",
  "postDesc": "Must have good experience in Core Java and Spring Boot",
  "reqExperience": 2,
  "postTechStack": [
    "Core Java",
    "Spring Boot",
    "Hibernate"
  ]
}
```

---

## Update Job

```http
PUT /jobs
```

---

## Delete Job

```http
DELETE /jobs/{postId}
```

---

## Search Jobs

```http
GET /jobs/keyword/{keyword}
```

Example:

```http
GET /jobs/keyword/java
```

---

# ▶️ Running the Application

## Clone Repository

```bash
git clone <repository-url>
```

## Navigate to Project

```bash
cd JobApp2
```

## Create Database

```sql
CREATE DATABASE job_db;
```

## Configure Database Credentials

Update:

```properties
application.properties
```

## Run Application

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

---

# 📚 Concepts Implemented

* REST API Development
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* Repository Pattern
* Layered Architecture
* Spring Security
* User Authentication
* JWT Authentication
* BCrypt Password Hashing
* Custom UserDetailsService
* Basic Authentication
* MySQL Integration
* Lombok

---

# 🚧 Future Improvements

* Role Based Authorization (ADMIN / USER)
* Refresh Tokens
* Global Exception Handling
* DTO Layer
* MapStruct Mapping
* Validation using Jakarta Validation
* Unit Testing
* Integration Testing
* Docker Support
* Swagger/OpenAPI Documentation

---

# 👨‍💻 Author

**Kranthi J**

Backend Developer | Java & Spring Boot Enthusiast

Learning in Public 🚀

---

# 🔖 Tags

`SpringBoot`
`SpringSecurity`
`Java`
`JPA`
`Hibernate`
`MySQL`
`RESTAPI`
`BackendDevelopment`
`Maven`
`Lombok`
`JWT`
