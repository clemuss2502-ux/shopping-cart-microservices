# 🛒 Shopping Cart Microservices

A Shopping Cart application built using a **Microservices Architecture** with **Spring Boot 3**, **Java 17**, **Spring Cloud OpenFeign**, **Spring Data JPA**, **H2 Database**, and **Swagger/OpenAPI**.

This project demonstrates how independent microservices communicate with each other while following clean architecture principles.

---

# 📖 Project Overview

The application is composed of three independent microservices:

| Service | Port | Description |
|---------|------|-------------|
| Product Service | 8081 | Retrieves product information from FakeStore API |
| Order Service | 8082 | Creates and manages customer orders |
| Payment Service | 8083 | Processes payments for existing orders |

---

# 🏗 Architecture

```
                    FakeStore API
                          ▲
                          │
                +-------------------+
                | Product Service   |
                |      :8081        |
                +---------+---------+
                          ▲
                          │ REST (Feign)
                +---------+---------+
                | Order Service     |
                |      :8082        |
                +---------+---------+
                          ▲
                          │ REST (Feign)
                +---------+---------+
                | Payment Service   |
                |      :8083        |
                +-------------------+
```

---

# 🛠 Technologies

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Cloud OpenFeign
- Maven
- H2 Database
- Lombok
- Swagger / OpenAPI
- REST APIs

---

# 📁 Project Structure

```
shopping-cart-microservices/

│── product-service
│── order-service
│── payment-service
│── README.md
```

Each microservice follows the same architecture:

```
controller

service

service.impl

repository

entity

dto

mapper

client

exception
```

---

# 🚀 Running the Project

## 1. Start Product Service

```
Port: 8081
```

Swagger

```
http://localhost:8081/swagger-ui/index.html
```

---

## 2. Start Order Service

```
Port: 8082
```

Swagger

```
http://localhost:8082/swagger-ui/index.html
```

H2 Console

```
http://localhost:8082/h2-console
```

---

## 3. Start Payment Service

```
Port: 8083
```

Swagger

```
http://localhost:8083/swagger-ui/index.html
```

H2 Console

```
http://localhost:8083/h2-console
```

---

# 📌 API Endpoints

## Product Service

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | /products | Retrieve all products |
| GET | /products/{id} | Retrieve a product by ID |

---

## Order Service

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /orders | Create a new order |
| GET | /orders | Retrieve all orders |
| GET | /orders/{id} | Retrieve an order by ID |
| DELETE | /orders/{id} | Delete an order |

---

## Payment Service

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /payments | Create a payment |
| GET | /payments | Retrieve all payments |
| GET | /payments/{id} | Retrieve a payment by ID |

---

# 🔄 Communication Flow

## Create Order

```
Client

↓

Order Service

↓

Product Service

↓

FakeStore API

↓

Calculate Total

↓

Save Order
```

---

## Create Payment

```
Client

↓

Payment Service

↓

Order Service

↓

Retrieve Order

↓

Save Payment
```

---

# 💾 Databases

The project uses H2 Database.

Order Service

```
jdbc:h2:file:./data/shoppingdb
```

Payment Service

```
jdbc:h2:file:./data/paymentdb
```

---

# 📸 Screenshots

You can include screenshots of:

- Swagger Product Service
- Swagger Order Service
- Swagger Payment Service
- H2 Order Database
- H2 Payment Database

Example:

```
screenshots/

product-swagger.png

order-swagger.png

payment-swagger.png

order-h2.png

payment-h2.png
```

---

# 📬 Testing

The project can be tested using:

- Swagger UI
- Postman

A Postman Collection is included in the project.

---

# 🔍 Design Decisions

Some design decisions adopted in this project:

- Layered Architecture
- DTO Pattern
- Mapper Pattern
- Global Exception Handling
- OpenFeign for service-to-service communication
- Independent databases for each microservice
- Validation using Jakarta Validation

---

# 🚀 Future Improvements

Possible enhancements:

- Spring Cloud Gateway
- Eureka Discovery Server
- Config Server
- Docker & Docker Compose
- MySQL/PostgreSQL
- JWT Authentication
- Resilience4j Circuit Breaker
- Unit and Integration Testing
- Kafka/RabbitMQ for asynchronous communication

---

# 👨‍💻 Author

**Carlos Enrique Lemus Serrano**

Java Developer

Spring Boot • Java 17 • Microservices • REST APIs# shopping-cart-microservices
