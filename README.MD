i# 🧑‍💼 Spring Boot CRUD REST API with MySQL – Employee Management

## 📌 Objective

This project demonstrates a simple **CRUD REST API** built with **Spring Boot** and **MySQL** to manage `Employee` records. It follows standard layered architecture with clean separation of concerns and proper exception handling.

---

## 🚀 Features

- ✅ Create a new employee
- ✅ Retrieve all employees
- ✅ Retrieve a single employee by ID
- ✅ Update employee details
- ✅ Delete an employee
- ✅ Proper error handling with HTTP status codes

---

## 🧩 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven

---

## 🗃️ Entity: Employee

Fields:
- `id` (Integer, auto-generated)
- `name` (String)
- `email` (String)
- `department` (String)

---

## 🔌 REST API Endpoints

| Method | Endpoint           | Description              |
|--------|--------------------|--------------------------|
| POST   | `/employees`       | Create a new employee    |
| GET    | `/employees`       | Get all employees        |
| GET    | `/employees/{id}`  | Get employee by ID       |
| PUT    | `/employees/{id}`  | Update employee by ID    |
| DELETE | `/employees/{id}`  | Delete employee by ID    |

---


