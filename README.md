# Banking Management System (Backend)

Welcome to the **AK Bank Management System**, a Spring Boot + PostgreSQL powered backend project that allows users to register, login, view, update, and delete banking profiles. Built to simulate real-world banking logic with clean code structure, validation, and REST APIs.

---

## 📌 Features

- User Registration with auto-generated account number
- Account number format like: `785AKBANK`, `001AKBANK`, etc.
- Input validation (including phone number format)
- Duplicate checks for email and phone
- Update, Get, Delete users by both ID and Account Number
- Global exception handling
- Clean service-repository-controller architecture

---

## 🧰 Tech Stack

| Layer        | Tool/Technology         |
|--------------|--------------------------|
| Backend      | Java 17, Spring Boot 3   |
| Database     | PostgreSQL               |
| ORM/DB Layer | Spring Data JPA (Hibernate) |
| API Testing  | Postman                  |
| Build Tool   | Maven                    |

---

## Project Structure

```bash
akbank-bms/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── akbank/
│       │           └── bms/
│       │               ├── controller/      # REST Controllers (UserController.java)
│       │               ├── entity/          # JPA Entities (User.java)
│       │               ├── repository/      # Spring Data Repositories (UserRepository.java)
│       │               ├── service/         # Business Logic Layer (UserService.java)
│       │               └── util/            # Utility Classes (AccountNumberGenerator.java)
│       └── resources/
│           ├── application.properties       # DB Config & Spring Boot Props
│           └── static/                      # (Optional) For serving static content
├── .gitignore
├── pom.xml
├── README.md
└── AkbankBmsApplication.java                 # Main class (Spring Boot entry point)

```


---

## 🗄️ Database Configuration (PgAdmin / PostgreSQL)

- Server name: `AK Bank Server`
- Database name: `akbankdb`
- Table: Automatically created as `users`

### ✅ PostgreSQL Connection

Ensure this is set inside `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/{akbankdb}
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
## How to Run This Project
Make sure PostgreSQL is running and database akbankdb is created before starting the app.

1. Clone this repo:
```bash
git clone https://github.com/akxhbaby2506/Bank-Management-System.git
```

2. Open the project in Spring Tool Suite 4 or VS Code

3. Right-click on AkbankBmsApplication.java → Run As → Spring Boot App

4. App starts at: http://localhost:8080


## How to Input via Postman

### Register a New User (POST /api/users)

Request Body:
```bash
{
  "fullName": "Enter your full name",
  "email": "Enter your email address",
  "password": "Enter your password",
  "phone": "Enter your 10-digit phone number",
  "balance": "Enter your initial balance"
}
```
📌 Account number is auto-generated like 785AKBANK.

### 📬 API Endpoints

| Method | Endpoint                                   | Description                     |
|--------|--------------------------------------------|---------------------------------|
| POST   | `/api/users`                               | Register a new user             |
| GET    | `/api/users`                               | Fetch all users                 |
| GET    | `/api/users/{id}`                          | Get user by ID                  |
| GET    | `/api/users/account/{accountNumber}`       | Get user by Account Number      |
| PUT    | `/api/users/{id}`                          | Update user by ID               |
| DELETE | `/api/users/{id}`                          | Delete user by ID               |
| DELETE | `/api/users/account/{accountNumber}`       | Delete user by Account Number   |


### 💡 Validations & Auto Formatting
- Phone number: Accepts only 10-digit valid numbers, auto-trims leading zeros

- Email: Must be unique

- Account number: Always ends in "AKBANK" and auto-formatted to uppercase

---

## ✍️ Author

**K K Akash Babu**  
Backend Developer | Java + Spring Boot  

> Let’s build something amazing 💛

---

## 📌 Notes

- 🖥️ **Frontend (React)** under development — will be integrated soon!
- 🔐 **Password encryption** and **login/auth system** will be added in the next update

---


