# Traini8 Training Centers Registry

This project is an MVP for a registry of Government-funded Training Centers built with Spring Boot.

## Features

- Create new training centers with validation
- Retrieve a list of all training centers
- Validation through annotations
- Exception handling with appropriate error messages
- Postgresql database

## API Endpoints

### 1. Create Training Center

- **URL**: `/api/training-centers`
- **Method**: `POST`
- **Request Body**: JSON with training center details
- **Validations**:
  - CenterName: Required, less than 40 characters
  - CenterCode: Required, exactly 12 alphanumeric characters
  - Address: Required (detailedAddress, city, state, pincode)
  - ContactPhone: Required, must be 10 digits
  - ContactEmail: Optional, but validated if present
- **Response**: Newly created training center data with ID

### 2. Get All Training Centers

- **URL**: `/api/training-centers`
- **Method**: `GET`
- **Response**: List of all training centers (empty list if none exist)

## Setup Instructions

### Prerequisites

- Java JDK 17 or higher
- Maven 3.6 or higher

### Steps to Run

1. **Clone the repository**

   ```
   git clone https://github.com/yourusername/traini8-registry.git
   cd traini8
   ```

2. **Setup applcation.properties**
   Navigate to:
   `src/main/resources/application.properties `
   Add the following content:

   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
   spring.datasource.username=your_database_user
   spring.datasource.password=your_database_password```

   ```

3. **Build the project**

   ```
   mvn clean install
   ```

4. **Run the application**
   ```
   mvn spring-boot:run
   ```

### Create a Training Center

```bash
curl -X POST http://localhost:8080/api/training-centers \
  -H "Content-Type: application/json" \
  -d '{
    "centerName": "Tech Training Hub",
    "centerCode": "TECH12345678",
    "address": {
      "detailedAddress": "123 Main Street",
      "city": "Bangalore",
      "state": "Karnataka",
      "pincode": "560001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Python", "Web Development"],
    "contactEmail": "contact@techtraininghub.com",
    "contactPhone": "9876543210"
  }'
```

### Get All Training Centers

```bash
curl -X GET http://localhost:8080/api/training-centers
```

## Technical Details

- Spring Boot 3.1.5
- Spring Data JPA
- Bean Validation API
- Lombok for reducing boilerplate code
