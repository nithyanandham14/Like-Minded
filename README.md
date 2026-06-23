# 🚀 LikeMinded - Innovation & Collaboration Platform

## Overview

LikeMinded is a full-stack collaboration platform that connects businesses, vendors, students, and innovators to solve real-world problems through teamwork and innovation.

The platform allows vendors to post problem statements, users to form teams, submit solutions, participate in project challenges, and receive rewards based on performance.

It serves as a bridge between industry requirements and student innovation.

---

## Key Features

### 👤 User Management
- User Registration
- Secure Login Authentication
- Profile Management
- Role-Based Access Control

### 🏢 Vendor Management
- Vendor Registration
- Vendor Profile Management
- Create Problem Statements
- Track Submitted Solutions

### 💡 Problem Management
- Post New Problems
- View Open Problems
- Manage Active Challenges
- Track Problem Status

### 👥 Team Collaboration
- Team Creation
- Team Participation
- Collaborative Problem Solving

### 📤 Submission Management
- Submit Project Solutions
- Track Submissions
- View Submission History

### 🏆 Selection Module
- Vendor Selection Process
- Team Evaluation
- Winner Selection

### 💳 Payment Management
- User Payments
- Vendor Payments
- Transaction Tracking

---

# System Workflow

```text
Vendor Creates Problem
           │
           ▼
Users View Open Problems
           │
           ▼
Create Teams
           │
           ▼
Submit Solutions
           │
           ▼
Vendor Reviews Submissions
           │
           ▼
Selection Process
           │
           ▼
Winner Announcement
           │
           ▼
Payment & Reward Distribution
```

---

# Technology Stack

## Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT Authentication
- Maven

## Database

- PostgreSQL

## Tools

- IntelliJ IDEA
- Postman
- Git
- GitHub

---

# Project Architecture

```text
Client
  │
  ▼
REST API
(Spring Boot)
  │
  ├── Authentication Module
  ├── User Module
  ├── Vendor Module
  ├── Problem Module
  ├── Team Module
  ├── Submission Module
  ├── Selection Module
  └── Payment Module
  │
  ▼
PostgreSQL Database
```

---

# API Endpoints

## Authentication

### Login

```http
POST /auth/login
```

---

## User APIs

### Register User

```http
POST /users/register
```

Request

```json
{
  "name":"John",
  "email":"john@example.com",
  "password":"password"
}
```

---

## Vendor APIs

### Register Vendor

```http
POST /vendor/register
```

### Vendor Profile

```http
GET /vendor/profile
```

---

## Problem APIs

### Create Problem

```http
POST /problems/vendor/create
```

### Get Open Problems

```http
GET /problems/open
```

### Get Vendor Problems

```http
GET /problems/vendor/my-problems
```

---

## Team APIs

### Create Team

```http
POST /teams/create
```

---

## Submission APIs

### Submit Solution

```http
POST /submissions/submit
```

### View Problem Submissions

```http
GET /submissions/problem/{problemId}
```

---

## Selection APIs

### Select Winning Team

```http
POST /selection/select
```

### Get Selected Teams

```http
GET /selection/problem/{problemId}
```

---

## Payment APIs

### Make Payment

```http
POST /payments/pay
```

### User Payment History

```http
GET /payments/user
```

### Vendor Payment History

```http
GET /payments/vendor
```

---

# Database Configuration

Configure PostgreSQL inside:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/likeminded_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Installation Guide

## Clone Repository

```bash
git clone https://github.com/yourusername/likeminded.git
```

## Navigate to Project

```bash
cd likeminded/demo
```

## Build Project

```bash
mvn clean install
```

## Run Application

```bash
mvn spring-boot:run
```

Application runs on:

```text
http://localhost:8080
```

---

# Testing APIs

## Step 1

Run the Spring Boot application.

---

## Step 2

Open Postman.

---

## Step 3

Test Authentication API:

```http
POST http://localhost:8080/auth/login
```

---

## Step 4

Copy JWT Token.

---

## Step 5

Add Authorization Header

```text
Authorization : Bearer YOUR_TOKEN
```

---

## Step 6

Test Protected APIs.

Example:

```http
GET http://localhost:8080/problems/open
```

---

# Future Enhancements

- React Frontend Integration
- Team Chat System
- Live Collaboration Workspace
- Project Milestone Tracking
- AI-Based Team Matching
- AI-Based Problem Recommendation
- Email Notifications
- Cloud Deployment (AWS)

---

# Business Value

LikeMinded helps:

- Students gain real-world project experience.
- Businesses solve operational challenges.
- Startups discover talented innovators.
- Teams collaborate on meaningful projects.
- Vendors identify the best solutions efficiently.

---

# Author

## Nithyanandham J

Java Backend Developer | Spring Boot Developer | Full Stack Developer

### Skills

- Java
- Spring Boot
- Spring Security
- PostgreSQL
- REST APIs
- JWT Authentication
- Hibernate
- Maven

---

⭐ If you found this project useful, please give it a Star on GitHub.
