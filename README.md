# Journal App

Spring Boot REST API for a personal journal application with authentication, journal entry management, weather-based greetings, Redis caching, Kafka-backed weekly sentiment notifications, email delivery, and Swagger API documentation.

## Features

- User signup and login with BCrypt password hashing
- JWT-based stateless authentication
- CRUD APIs for journal entries scoped to the authenticated user
- MongoDB persistence with user-to-entry references
- Redis caching for weather API responses
- Weekly sentiment summary job using Spring Scheduler and Kafka
- Email fallback for sentiment notifications
- Google OAuth callback support
- Swagger/OpenAPI documentation

## Tech Stack

- Java 21
- Spring Boot 3.4
- Spring Security
- Spring Data MongoDB
- Redis
- Apache Kafka
- Maven
- JUnit 5 and Mockito

## Configuration

The app reads secrets and service settings from environment variables.

| Variable | Purpose | Default |
| --- | --- | --- |
| `JWT_SECRET` | JWT signing secret. Use a strong 32+ character value. | development placeholder |
| `MONGODB_URI` | MongoDB connection string | `mongodb://localhost:27017/journaldb` |
| `REDIS_HOST` | Redis host | `localhost` |
| `REDIS_PORT` | Redis port | `6379` |
| `REDIS_PASSWORD` | Redis password | empty |
| `KAFKA_SERVERS` | Kafka bootstrap servers | `localhost:9092` |
| `KAFKA_USERNAME` | Kafka SASL username | empty |
| `KAFKA_PASSWORD` | Kafka SASL password | empty |
| `JAVA_EMAIL` | SMTP username | `dummy@example.com` |
| `JAVA_EMAIL_PASSWORD` | SMTP password | development placeholder |
| `WEATHER_API_KEY` | Weather API key | development placeholder |
| `GOOGLE_CLIENT_ID` | Google OAuth client id | development placeholder |
| `GOOGLE_CLIENT_SECRET` | Google OAuth client secret | development placeholder |

## Run Locally

```bash
mvn spring-boot:run
```

The API starts at:

```text
http://localhost:8080/journal
```

Swagger UI is available at:

```text
http://localhost:8080/journal/swagger-ui/index.html
```

## Test

```bash
mvn test
```

Most tests are unit-level and use Mockito so they can run without live mail, Redis, Kafka, or MongoDB services.

## Main Endpoints

- `POST /public/signup` - create user
- `POST /public/login` - login and receive JWT
- `GET /journal` - list authenticated user's journal entries
- `POST /journal` - create journal entry
- `GET /journal/id/{id}` - fetch one journal entry
- `PUT /journal/id/{id}` - update one journal entry
- `DELETE /journal/id/{id}` - delete one journal entry
- `GET /user` - authenticated greeting with weather summary
- `PUT /user` - update authenticated user
- `DELETE /user` - delete authenticated user

## Resume Summary

Built a Spring Boot journal backend with JWT authentication, MongoDB persistence, Redis caching, Kafka-based weekly sentiment notifications, scheduled jobs, email integration, Google OAuth callback support, and Swagger API documentation.
