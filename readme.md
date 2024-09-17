# makersharks-assessment

## Prerequisites

Ensure you system have met the following requirements:

- Java Development Kit (JDK) 17
- Maven 3.6.3 or higher (Optional if you are running project only in IDE. If you want to run it command line then it is necessary. )



---


## Project Dependencies

- **Spring Boot Starter Data JPA**: For JPA-based data access.
- **Spring Boot Starter Validation**: For Java Bean Validation.
- **Spring Boot Starter Web**: For web applications, including REST.
- **Spring Boot Starter Security**: For authentication and authorization.
- **H2 Database**: In-memory database for development.
- **MySQL Connector**: Connector for MySQL database.
- **JWT**: For handling JSON Web Tokens (API, Implementation, and Jackson).
- **Springdoc OpenAPI**: For API documentation and Swagger UI.
- **Spring Boot Starter Test**: For testing purposes.

---

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Siddpawar9222/makersharks-assessment.git
   ```

2. **Reach to parent directory:**

   ```bash
   cd makersharks-assessment
   ```

3. **Open Project in your favourite IDE.**

## Running the Application

1. **Run the Spring Boot application:**
   You can run the application using Maven or from your IDE.

   **Build the project:**

   ```bash
   mvn clean install
   ```

   **Using Maven:**

   ```bash
   mvn spring-boot:run
   ```

   **Using the executable WAR:**

   ```bash
   java -jar target/makersharks-assessment.jar
   ```

2. **Access the application:**
   Open your web browser or postman and go to `http://localhost:8080/test/welcome`. This open url to test application.

---

## API Endpoints


### Swagger Documentation

You can view the Swagger documentation for the API at the following URL:

- **Swagger UI:** [http://localhost:8080/swagger/makersharks-documentation](http://localhost:8080/swagger/makersharks-documentation)
- **API Docs:** [http://localhost:8080/swagger/makersharks-api-docs](http://localhost:8080/swagger/makersharks-api-docs)


### User Registration

This endpoint allows new users to register by providing their email, password, and roles (optional).

- **URL:** `http://localhost:8080/api/auth/register`
- **Method:** `POST`
- **Content-Type:** `application/json`
- **Request Body Example:**

  ```json
  {
     "email": "siddheshpawar95@gmail.com",
     "password": "123456789",
     "roles": ["user", "admin"]
  }
  ```
  
   - `email`: Required. Should not be repeated
   - `password`: Required. Should be 6 characters long.
   - `roles`: Optional. Should be an array of strings. If not provided, it will default to `["user"]`.
  

- **Response Example:**

  ```json
  {
      "message": "Registration Successful....Please Login",
      "data": {
          "id": 2,
          "email": "siddheshpawar95@gmail.com",
          "password": "******",
          "roles": [
              "user",
              "admin"
          ]
      },
      "resultCode": 201,
      "timestamp": "2024-08-23 09:39:48"
  }
  ```

- **cURL Command:**

  ```bash
  curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
     "email": "siddheshpawar95@gmail.com",
     "password": "123456789",
     "roles": ["user", "admin"]
  }'
  ```

### Notes:
- The `cURL` command sends a POST request to the `/api/auth/register` endpoint.
- The `-H "Content-Type: application/json"` flag specifies that the request body is in JSON format.
- The `-d` flag is used to pass the JSON data in the request body.

---

### User Login

This endpoint allows users to log in by providing their email and password.

- **URL:** `http://localhost:8080/api/auth/login`
- **Method:** `POST`
- **Content-Type:** `application/json`
- **Request Body Example:**

  ```json
  {
    "email": "siddhesh@gmail.com",
    "password": "123456"
  }
  ```
  **Note:** You can use above email and password for testing. Backend will automatically add above credentials when application runs.  

- **Response Example:**

  ```json
  {
    "message": "Login Successful",
    "data": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoic2lkZGhlc2hAZ21haWwuY29tIiwiaWF0IjoxNzI0Mzg2NTkzLCJleHAiOjE3MjQzODgzOTN9.CA1zuhhz84hBUEK0hRZ2VN54u9UZUgMXXOB0LT2qLHE",
    "resultCode": 200,
    "timestamp": "2024-08-23 09:46:32"
  }
  ```

- **cURL Command:**

  ```bash
  curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "siddhesh@gmail.com",
    "password": "123456"
  }'
  ```

### Notes:
- The `cURL` command sends a POST request to the `/api/auth/login` endpoint.
- The `-H "Content-Type: application/json"` flag specifies that the request body is in JSON format.
- The `-d` flag is used to pass the JSON data in the request body.
- The response includes a JWT (JSON Web Token) in the `data` field, which can be used for authenticated requests.

---

### Search Supplier

This endpoint allows you to search for suppliers based on location, nature of business, and manufacturing processes, with pagination support.

- **URL:** `http://localhost:8080/api/supplier/searchSupplier?location=India&nature_of_business=small_scale&manufacturing_processes=casting&pageNumber=0&pageSize=5`
- **Method:** `POST`
- **Authentication:** Bearer Token (Include in the `Authorization` header)
- **Content-Type:** `application/json`
- **Request Parameters:**
 
 
   - `location`: Required. 
   - `nature_of_business`: Required.
   - `manufacturing_processes`: Required.
   - `pageNumber`: Optional. Backend will default to 0 if not provided.
   - `pageSize`: Optional. Backend will default to 5 if not provided. 

- **Request Headers:**

  ```http
  Authorization: Bearer [Your_Token_Here]
  ```

- **Response Example:**

  ```json
  {
    "message": "Data fetched successfully",
    "data": {
        "pageNumber": 0,
        "isLastPage": false,
        "totalPages": 4,
        "pageSize": 5,
        "isFirstPage": true,
        "content": [
            {
                "supplierId": 43,
                "companyName": "Tau Industries",
                "website": "http://tau-industries.com",
                "location": "India",
                "natureOfBusiness": "small_scale",
                "manufacturingProcesses": "casting"
            },
            {
                "supplierId": 51,
                "companyName": "Shree Casting",
                "website": "http://shreecasting.com",
                "location": "India",
                "natureOfBusiness": "small_scale",
                "manufacturingProcesses": "casting"
            },
            {
                "supplierId": 52,
                "companyName": "Bharat Foundries",
                "website": "http://bharatfoundries.com",
                "location": "India",
                "natureOfBusiness": "small_scale",
                "manufacturingProcesses": "casting"
            },
            {
                "supplierId": 53,
                "companyName": "Mithila Metals",
                "website": "http://mithilametals.com",
                "location": "India",
                "natureOfBusiness": "small_scale",
                "manufacturingProcesses": "casting"
            },
            {
                "supplierId": 54,
                "companyName": "Vishnu Castings",
                "website": "http://vishnucastings.com",
                "location": "India",
                "natureOfBusiness": "small_scale",
                "manufacturingProcesses": "casting"
            }
        ],
        "totalElements": 16
    },
    "resultCode": 200,
    "timestamp": "2024-08-23 09:48:11"
  }
  ```

- **cURL Command:**

  ```bash
  curl -X POST "http://localhost:8080/api/supplier/searchSupplier?location=India&nature_of_business=small_scale&manufacturing_processes=casting&pageNumber=0&pageSize=5" \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer [Your_Token_Here]"
  ```

### Notes:
- The `cURL` command sends a POST request with query parameters for filtering and pagination.
- The `Authorization` header should include a valid Bearer token for authentication.
- The response includes pagination details and a list of suppliers matching the criteria.

---














