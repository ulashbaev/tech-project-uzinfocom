# Microservice System

## Overview

This project implements a microservice-based system using Spring Boot, Spring Cloud, and JWT for secure and modular architecture.

## 🎯 Goal

Demonstrate a junior developer's ability to:

* Design and implement microservices
* Use JWT-based authentication and authorization
* Perform CRUD operations
* Structure microservices using modern Java frameworks

---

## 🧱 Project Structure

```
microservice-system/
├── discovery-service          # Eureka Server
├── api-gateway               # Spring Cloud Gateway
├── auth-service              # Auth + JWT
├── classificator-service     # Country/Region/District management
└── README.md
```

---

## 🔧 Technologies Used

| Technology      | Purpose                             |
| --------------- | ----------------------------------- |
| Java 17         | Main language (LTS version)         |
| Spring Boot 3.1 | Framework base                      |
| Spring Cloud    | Gateway, Discovery (Netflix Eureka) |
| Eureka Server   | Service registry                    |
| Spring Security | Security configuration              |
| JWT (JJWT)      | Stateless authentication            |
| PostgreSQL      | Database for persistent storage     |
| MapStruct       | Entity/DTO conversion               |
| Lombok          | Less boilerplate code               |

---

## 🧩 Microservices

### 1. Discovery Service

* Port: `8761`
* Purpose: Service registry via Netflix Eureka
* Configured as a central registry where all services register

### 2. API Gateway

* Port: `8080`
* Routes:

  * `/auth/**` → `auth-service`
  * `/api/**` → `classificator-service`
* Performs JWT validation via `auth-service` `/auth/me` endpoint

### 3. Auth Service

* Port: `8081`
* Responsibilities:

  * `POST /auth/register` → register user
  * `POST /auth/login` → return JWT token
  * `GET /auth/me` → validate JWT
* Security:

  * Spring Security + JWT (JJWT library)
  * BCrypt for password encryption
  * MapStruct used to map DTOs to entities

### 4. Classificator Service

* Port: `8082`
* Manages:

  * `/api/countries` → CRUD for countries
  * `/api/regions` → CRUD for regions (linked to countries)
  * `/api/districts` → CRUD for districts (linked to regions)
  * `/api/init` → Load initial data from `init-data.json`
* Security:

  * JWT is validated upstream by the Gateway
  * No Spring Security layer inside
* Structure:

  * Entities: `Country`, `Region`, `District`
  * DTOs: `CountryDto`, `RegionDto`, `DistrictDto`
  * Mappers: MapStruct mappers for each entity
  * Controllers: CRUD + init

---

## 🔐 Security Design

* Auth-service generates and validates JWTs.
* Gateway filters all requests to `/api/**` and forwards them only if `auth/me` validates the token.
* This keeps services decoupled and follows the separation of concerns principle.

---

## 📂 Data Initialization

* File: `src/main/resources/init-data.json`
* Endpoint: `POST /api/init`
* Description: Loads `countries`, `regions`, and `districts` into the database.
* Implemented via `ObjectMapper` + service + repository logic

---

## ✅ How it Works (Flow)

1. Register at `/auth/register`
2. Login and receive a JWT from `/auth/login`
3. Send requests to `/api/**` with header:

   ```
   Authorization: Bearer <your-token>
   ```
4. Gateway verifies the token via `/auth/me`
5. If valid, request is routed to `classificator-service`

---

## 🚀 Getting Started

1. Run `discovery-service`
2. Run `auth-service`
3. Run `api-gateway`
4. Run `classificator-service`
5. Test the flow using Postman or curl

---

## 💡 Future Improvements

* Add role-based access control
* Add pagination and filtering to CRUD endpoints
* Add Swagger for documentation
* Dockerize each service

---

## 📎 License

MIT License

---

## 👤 Author

Developed as a test project to demonstrate Java microservices with Spring ecosystem.
