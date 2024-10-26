# Email Scheduler

A Spring Boot 3 application that provides user management with CRUD operations and a scheduled email sending feature using Quartz Scheduler. This application is built with Java 21 and uses Gradle for dependency management.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)

## Features

- **CRUD Operations**: Create, Read, Update, and Delete users.
- **Email Notifications**: Send email notifications to all users.
- **Scheduled Tasks**: Use Quartz Scheduler to send emails based on a cron expression.

## Technologies Used

- **Spring Boot**: 3.x
- **Java**: 21
- **Gradle**: Build tool
- **Database**: H2 (in-memory database for development)
- **Spring Data JPA**: For data persistence
- **Spring Mail**: For sending emails
- **Spring Quartz**: For scheduling tasks
- **Lombok**: For reducing boilerplate code

## Getting Started

### Prerequisites

- JDK 21
- Gradle

### Clone the repository

```bash
git clone https://github.com/yourusername/spring-scheduled-email.git
cd spring-scheduled-email
```
### Configuration
Edit the `username` and `password` field on `application.yml`

### Build the application
Run the following command to build the project:
``` bash
./gradlew build
```
### Run the application
Use the following command to run the application:
``` bash
./gradlew bootRun
```
## API Endpoints
|Method|Endpoint|Description|
|------|--------|-----------|
|GET|	/users|	Retrieve a list of all users|
|GET|	/users/{id}|	Retrieve a user by ID|
|POST|	/users|	Create a new user|
|PUT|	/users|	Update an existing user|
|DELETE|	/users/{id}|	Delete a user by ID|
|GET|	/send-email	|Send email to all users|
|GET|	/schedule?exp	|Schedule email sending using a cron expression (example: `epx=0 */3 * * * ?` set cron job to run every 3 minutes)|



