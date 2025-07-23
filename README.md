# APITEST
A RESTful API for generating and storing user tokens in a PostgreSQL database.  
Developed using Java 21, Spring Boot 3.3.9, JPA, and Swagger UI for API documentation.


## Features

- [x] `POST /insert` – Save user data and token into database
- [x] `GET /getall` – Retrieve all users as response DTO
- [x] Swagger UI for testing and documentation
- [x] Integrated with PostgreSQL 15

## Technologies Used
  - Java 21
  - Spring Boot 3.3.9
  - Spring Web
  - Spring Data JPA
  - PostgreSQL
  - springdoc-openapi (Swagger)
  - Maven
    
## Installing
  - install Oracle JDK 21
  - install Apache Maven 3.9.11
  - install Postgres 15 for used Database
  - install IntelliJ IDEA for Run Code

```
  ## Project Structure
   APITEST/
|---apiTest/
|      |--src/
|        |--main/
|            |--java/
|               |--com/example/apitest/
|                  |--controller/
|                     |--TokenController.java
|                  |--dto/
|                     |--TokenResponse.java
|                     |--TokenRequest.java
|                     |--UserResponseDTO.java
|                  |--entity/
|                     |--SsoUserEntity.java
|                  |--repository/
|                     |--SsoUserRepository.java
|                  |--service/
|                     |--TokenService.java
|                  |--ApitestApplication.java
|            |--resources
|               |--application.properties
|   |--pom.xml
|   |--.gitignore
|   |--.gitattributes
```  

## Database Configuration

| Property    | Value           |
|-------------|-----------------|
| Host        | `localhost`     |
| Port        | `5432`          |
| Database    | `ssotest`       |
| Username    | `ssodev`        |
| Password    | `sso2022ok`     |

## Table `sso_user_test`
Request Parameters
| No | Item Name               | Multi   | Data Type | MaxLen | Description                                                           |
| -- | ----------------------- | ------- | --------- | ------ | --------------------------------------------------------------------- |
| 1  | `ssoType`               | \[1..1] | String    | -      | Type of data set                                                      |
| 2  | `systemId`              | \[1..1] | String    | -      | System ID                                                             |
| 3  | `systemName`            | \[1..1] | String    | -      | System name (display name)                                            |
| 4  | `systemTransactions`    | \[1..1] | String    | -      | List of authorized transactions for the system in abbreviated form    |
| 5  | `systemPrivileges`      | \[1..1] | String    | -      | Usage permission flags (e.g. read/write/etc.), represented as numbers |
| 6  | `systemUserGroup`       | \[1..1] | String    | -      | System-level user group                                               |
| 7  | `systemLocationGroup`   | \[1..1] | String    | -      | Client device group/location group                                    |
| 8  | `userId`                | \[1..1] | String    | -      | User ID used to log in                                                |
| 9  | `userFullName`          | \[1..1] | String    | -      | Full name of the user                                                 |
| 10 | `userRdOfficeCode`      | \[1..1] | String    | -      | RD office code of the user                                            |
| 11 | `userOfficeCode`        | \[1..1] | String    | -      | Operating office code of the user                                     |
| 12 | `clientLocation`        | \[1..1] | String    | -      | Device location code                                                  |
| 13 | `locationMachineNumber` | \[1..1] | String    | -      | Device machine number                                                 |
| 14 | `tokenId`               | \[1..1] | String    | -      | Token ID issued by the SSO system                                     |

### 📄 `application.properties`

```properties
spring.application.name=apitest

# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/ssotest
spring.datasource.username=ssodev
spring.datasource.password=sso2022ok
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA / Hibernate Config
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
## How to Run
1.Open Project in IntelliJ IDEA

2.Run Project

3.Open link Swagger [http://localhost:8080/apitest/swagger-ui.html](http://localhost:8080/swagger-ui/index.html)

4.Choose POST /apitest/insert and Click try it out

5.Test Project with samples request this

Request Body
```
{
  "ssoType": "SSOData",
  "systemId": "VATDEDEV",
  "systemName": "ระบบบันทึกข้อมูลภาษีมูลค่าเพิ่มทดสอบ)",
  "systemTransactions": "PRIV-010,PRIV-020,PRIV-040,PRIV-050",
  "systemPrivileges": "0|0|0|0",
  "systemUserGroup": "GRP-010,GRP-020,GRP-040",
  "systemLocationGroup": "CliC001",
  "userId": "WS233999",
  "userFullName": "ประสาท จันทร์อังคาร ",
  "userRdOfficeCode": "01000999",
  "userOfficeCode": "01001139",
  "clientLocation": "01001139",
  "locationMachineNumber": "CLI00000718-9999",
  "tokenId": "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9"
}
```

Response: 200 OK
```
{
  "responseCode": "I07000",
  "responseMessage": "Transaction successful",
  "responseData": {
    "userId": "WS123456",
    "tokenId": "eyJhbGciOiJ..." 
  }
}
```

6.Choose GET /apitest/getall and Click try it out

Response Example
```
[
  {
    "userId": "WS233999",
    "userFullName": "ประสาท จันทร์อังคาร ",
    "systemId": "VATDEDEV",
    "tokenId": "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9"
  },
  {
    "userId": "WS233999",
    "userFullName": "ประสาท จันทร์อังคาร ",
    "systemId": "VATDEDEV",
    "tokenId": "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9"
  },
  {
    "userId": "WS233999",
    "userFullName": "ประสาท จันทร์อังคาร ",
    "systemId": "VATDEDEV",
    "tokenId": "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9"
  }
]
```
7.Click Execute

8.Check Response

## Notes
 - If request is invalid (e.g. missing userId or tokenId), it returns HTTP 400
 - If database cannot be connected, returns HTTP 500
