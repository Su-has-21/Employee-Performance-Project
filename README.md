# Employee Performance Project

This project provides a solution for creating a bell curve for performance appraisal based on employee details, rating categories, and appraisal ranges. It includes a backend developed using Spring Boot and a simple frontend using HTML and JavaScript.

---

## Features

1. **Employee Performance Analysis**:
   - Calculates actual rating percentages.
   - Compares actual percentages with standard percentages.
   - Identifies deviations from the standard bell curve.
   - Suggests adjustments for employee ratings.

2. **Technologies Used**:
   - **Backend**: Spring Boot, Spring Data JPA, H2 Database.
   - **Frontend**: HTML, CSS, JavaScript.

---

## Prerequisites

1. **Java JDK**: Version 11 or higher.
2. **Maven**: For dependency management and build.
3. **Eclipse IDE**: (or any IDE supporting Spring Boot).
4. **Database**:
   - H2 (for development) or MySQL/PostgreSQL (for production).

---

## Project Setup

### Backend Setup

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd EmployeeAppraisal
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the APIs:
   - Base URL: `http://localhost:8080`

### Frontend Setup

1. Place the `index.html` file in the `src/main/resources/static` directory.
2. The frontend will be accessible at `http://localhost:8080` once the backend is running.

---

## API Endpoints

### 1. Get Actual Percentages
**GET** `/api/appraisal/percentages`
- Returns the actual percentages of ratings.

### 2. Get Deviation from Standard
**GET** `/api/appraisal/deviation`
- Returns the deviation between actual and standard percentages.

### 3. Get Suggested Adjustments
**GET** `/api/appraisal/suggestions`
- Returns employees whose ratings should be adjusted to align with the bell curve.

---

## Database Configuration

### MySQL 
1. Create a database named `appraisaldb`.
2. Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/appraisaldb
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   ```

---

## Project Structure

```
EmployeeAppraisal
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.employeeappraisal
│   │   │       ├── EmployeeAppraisalApplication.java (Main Application)
│   │   │       ├── controller
│   │   │       │   └── AppraisalController.java (REST Endpoints)
│   │   │       ├── model
│   │   │       │   ├── Employee.java (Entity)
│   │   │       │   └── RatingCategory.java (Enum for Ratings)
│   │   │       ├── repository
│   │   │       │   └── EmployeeRepository.java (Database Interface)
│   │   │       └── service
│   │   │           └── AppraisalService.java (Business Logic)
│   │   └── resources
│   │       ├── application.properties (Configuration)
│   │       └── static
│   │           └── index.html (Frontend)
└── pom.xml (Maven Dependencies)
```

---

## Possible Enhancements

1. Add user authentication and role-based access control.
2. Extend the frontend using React, Angular, or Vue.js.
3. Integrate caching using Redis for better performance.
4. Add unit and integration tests for complete coverage.

---

