# Spring MVC Quiz Application

A simple **Spring Boot + Spring MVC + Thymeleaf** quiz application that displays **one question per page**, allows users to navigate through questions, and shows the final score at the end.

---

## Technologies Used

* Java (Spring Boot)
* Spring MVC
* Thymeleaf (Template Engine)
* Spring Data JPA
* MySQL
* Bootstrap 5

---

## ## Setup Instructions / ## Cloning from GitHub

you can clone it to your local machine:

- Open a terminal or Git Bash
- Navigate to the folder where you want to clone the project
- Run the clone command (replace <repo-url> with your GitHub repository URL):
- git clone <repo-url>
- Navigate into the cloned folder:
- cd <project-folder-name>
- Open the project in your IDE  IntelliJ
- Configure the database connection in application.properties (see Database Configuration)


---

### 2. Create MySQL Database

```sql
CREATE DATABASE quiz_db;
USE quiz_db;
```

---

### 3.Configure Database (`application.properties`)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

### 4. Run the Application

Run the main class:

```
SpringMvcQuizApplication.java
```

---

## How It Works

1. User visits:

```
http://localhost:8080/
```

2. Redirects to:

```
/question/0
```

3. Each question is shown one at a time

4. User selects an answer and clicks **Next**

5. Answers are stored in session:

6. After the last question:

* Score is calculated
* Result page is displayed

--