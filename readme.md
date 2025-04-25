# Money Transfer API

A RESTful API built with Spring Boot for handling money transfers between accounts.

## Features

- Create accounts with an initial balance
- Transfer money between accounts (with timestamp )
- View all accounts
- MySQL storage via Spring Data JPA
- Containerized using Docker
- Basic bash script for API testing

## Technology Stack

- Java 21+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Docker

## How to Run

### Prerequisites
- Java 21+
- Maven
- Docker (for containerized execution)

### Option 1: Run via Maven and Java

```bash
# Build the application
mvn clean package

# Run the fat jar
java -jar target/money-transfer-api-0.0.1-SNAPSHOT.jar
```

### Option 2: Run via Docker Compose

```bash
docker-compose up --build
```

The API will be available at: http://localhost:8080

## Testing the API

A simple bash script is provided to automatically test the API:

```bash
# Run the test script in bash 
./test.sh
```

Or you can manually use curl commands.

## API Endpoints
### Accounts
`POST /api/accounts` — Create a new account
   Example JSON Body:
   {
     "owner": "Alice",
     "balance": 1000.00
   }
  
`GET /api/accounts` — Retrieve all accounts

### Transfers
`POST /api/transfer` — Transfer money between accounts
   Example JSON Body:
   {
     "from": 1,
     "to": 2,
     "amount": 100.00
   }


## Decision making

### Focused On:

Mainly I focused on core functionality, that is creating accounts and trasfer of money is done safely and correctly. Focused also on on a clean MVC structure which makes the project more understandble. JPA for database calls, avoiding having to make SQL calls ourself which adds simplicity. Two seperate containers, one of them has the MYSQL DB and one of them the app's fat jar.

### Did Not Focus On:

- Complex validation haven't been done, and only made basic checks for example balance sufficiency. 
- Swagger documentation, the focus was mainly backend logic.
- Did not focus on extensive error handling or logging
- Automated unit testing 


###  Future improvements
* Add proper error responses with HTTP codes (400/404/500).
* Use DTOs instead of Map<String, String> for request bodies.
* Create more detailed validations ( example invalid input format )
* Add Swagger UI for easy API documentation.

