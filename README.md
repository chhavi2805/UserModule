# User Module - Spring Boot Application

This module provides **User Management APIs** with essential functionalities such as creating a user, authentication, fetching user details, resetting passwords, and deactivating user accounts.

---

## 🚀 Features
- **Add User** – Register a new user.
- **Login User** – Authenticate an existing user and generate a session/token.
- **Find User** – Retrieve user details by ID or username.
- **Reset Password** – Update password securely for a user.
- **Deactivate User** – Soft-delete/deactivate a user account.

---

## ⚙️ Tech Stack
- **Spring Boot** (REST APIs)
- **Spring Data JPA / Hibernate**
- **Spring Security** (for login & password management)
- **MySQL / PostgreSQL / H2** (configurable database)
- **Lombok** (boilerplate code reduction)
- **Maven / Gradle** (build tool)

---

## 📂 Project Structure
src/main/java/com/example/usermodule
│── controller/ # REST controllers
│── service/ # Business logic
│── repository/ # JPA repositories
│── model/ # Entity classes
│── dto/ # Request/response objects
│── exception/ # Custom exceptions
