# Review Service

## Overview

The **Review Service** manages course reviews and ratings within the E-Learn Microservices Platform. It allows learners to submit ratings and feedback only after purchasing a course, ensuring authentic reviews and maintaining the overall quality of course evaluations.

The service also publishes review events to Kafka, enabling asynchronous processing for analytics, notifications, and future recommendation systems.

---

## Responsibilities

* Add Course Reviews
* Course Rating Management
* Review Validation
* Duplicate Review Prevention
* Purchase Verification
* Review Retrieval
* Average Rating Calculation
* Kafka Event Publishing
* Review Statistics

---

## Technology Stack

* Java 17
* Spring Boot 3
* Spring Data JPA
* Spring Cloud Eureka Client
* Spring Cloud OpenFeign
* Apache Kafka
* H2 Database (Current)
* MySQL (Future)
* Spring Boot Actuator
* OpenAPI / Swagger

---

## Features

### Review Management

* Add Review
* View Course Reviews
* View User Reviews
* Average Rating Calculation
* Review Count Management

---

### Business Rules

* Only purchased users can review a course
* One review per user per course
* Rating validation
* Duplicate review prevention
* Real-time event publishing using Kafka

---

## Architecture

```text
                Angular Frontend
                        │
                        ▼
                  API Gateway
                        │
                        ▼
                  Review Service
                        │
         ┌──────────────┼──────────────┐
         ▼              ▼              ▼
 Purchase Service   Course Service    Database
         │                              │
         └──────────────┬───────────────┘
                        ▼
                     Apache Kafka
```

---

## REST APIs

### Review Management

| Method | Endpoint                                | Description           |
| ------ | --------------------------------------- | --------------------- |
| POST   | `/api/reviews`                          | Add Review            |
| GET    | `/api/reviews/course/{courseId}`        | Get Reviews by Course |
| GET    | `/api/reviews/user/{userId}`            | Get Reviews by User   |
| GET    | `/api/reviews/course/{courseId}/rating` | Get Average Rating    |

---

## Database

Current Database

* H2 Database

Future Migration

* MySQL

Future Improvements

* Flyway Database Migration
* Review Moderation
* Review Reports
* Audit History

---

## Service Communication

The Review Service communicates with other microservices using Spring Cloud OpenFeign.

Current integrations include:

* Purchase Service (Purchase Validation)
* Course Service

Future integrations:

* Notification Service
* Analytics Service
* Recommendation Service

---

## Kafka Integration

Every successful review publishes a Kafka event.

Current Event

```text
Review Created
```

Future Consumers

* Notification Service
* Analytics Service
* Recommendation Engine
* Search Service

---

## Event Flow

```text
User Adds Review
        │
        ▼
Review Service
        │
        ▼
Purchase Validation
        │
        ▼
Save Review
        │
        ▼
Publish Kafka Event
        │
 ┌──────┼─────────────┐
 ▼      ▼             ▼
Analytics  Notification  Recommendation
```

---

## Eureka Integration

The service automatically registers with Eureka Server.

Service Name:

```text
REVIEW-SERVICE
```

No hardcoded URLs are used.

---

## Monitoring

Spring Boot Actuator endpoints are enabled.

Available endpoints:

* `/actuator/health`
* `/actuator/info`
* `/actuator/prometheus`
* `/actuator/metrics`

---

## Future Enhancements

* Review Editing
* Review Deletion
* Review Moderation
* Like/Dislike Reviews
* Review Replies
* Report Review
* AI Spam Detection
* Sentiment Analysis
* Redis Cache
* Elasticsearch Review Search
* Kafka Event Consumers

---

## Future Architecture

```text
                  API Gateway
                       │
                       ▼
                 Review Service
                       │
      ┌────────────────┼────────────────┐
      ▼                ▼                ▼
   MySQL          Redis Cache        Kafka
      │                                  │
      ▼                                  ▼
Review Storage        Analytics & Notifications
```

---

## Project Structure

```text
review-service
│
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── exception
├── config
├── kafka
├── util
├── constant
├── resources
└── ReviewServiceApplication.java
```

---

## Role in E-Learn Platform

The Review Service ensures that course ratings and learner feedback remain authentic by allowing reviews only from enrolled users. It maintains rating statistics, publishes review events for asynchronous processing, and contributes to improving course quality through user feedback.

---

## Future Roadmap

* AI-based Review Summarization
* Review Recommendation Engine
* Course Rating Trends
* Instructor Analytics
* Review Dashboard
* Elasticsearch Integration
* Event-Driven Analytics
* Real-Time Notifications

---

## Author

**Anil Mondi**

