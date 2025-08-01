# 🧾 Project Quote API

This is a full-stack project consisting of a **Spring Boot** backend (Java, Maven) and a **React** frontend. The backend exposes RESTful APIs for submitting and listing project quote requests, using **PostgreSQL** for persistence, **Spring Data JPA** for ORM, and **Lombok** to reduce boilerplate code.

## 🌐 Frontend

👉 [React Frontend Repository](https://github.com/Orlin99/Company-Frontend)

## 🧰 Tech Stack

- **Backend**: Java, Spring Boot, Maven, JPA (Hibernate), Lombok  
- **Database**: PostgreSQL  
- **Frontend**: React  
- **Other**: Spring ControllerAdvice for global exception handling  

## 🗄️ Database Configuration

1. **Install PostgreSQL** if not already installed.
2. **Create a database**:

```sql
CREATE DATABASE company_database;
```

3. Update your `application.properties` file according to your environment.

4. Clone the Repository in your machine.

## 📮 API Usage with Postman

1. POST:

**URL** - `http://localhost:8080/api/v1/project-quote/submit-details`
**Request Body**
```json
{
  "name": "Some Name",
  "email": "legitemailaddress@gmail.com",
  "phoneNumber": "0882 123 456",
  "companyName": "My Own Company",
  "companyService": "Development",
  "companyBudget": "$20.000 - $50.000"
}
```

2. GET:

**URL** - `http://localhost:8080/api/v1/project-quote/list-quotes`

## 🧠 Error Handling

This project uses `@ControllerAdvice` to globally handle exceptions like validation errors.
