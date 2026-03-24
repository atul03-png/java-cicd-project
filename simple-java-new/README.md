# Simple Java — Jenkins CI/CD Project

Spring Boot REST API with complete CI/CD pipeline.

## Pipeline Stages
1. Checkout       — GitHub se code pull
2. Build & Test   — Maven build + JUnit tests
3. SonarQube      — Code quality scan
4. Quality Gate   — Quality fail = pipeline stops
5. Package        — JAR file banao
6. Docker Build   — Docker image banao
7. Push to ECR    — AWS ECR par push karo
8. Deploy         — ECS service update

## Setup (Jenkins mein)

### Tools (Manage Jenkins → Tools)
- JDK: naam = `JDK-17`
- Maven: naam = `Maven-3.9`

### Credentials (Manage Jenkins → Credentials)
| ID              | Type           |
|-----------------|----------------|
| sonar-token     | Secret text    |
| aws-creds       | AWS Credentials|
| aws-account-id  | Secret text    |

### SonarQube (Manage Jenkins → System)
- Naam: `sonarqube-server`
- URL: `http://<sonar-ip>:9000`

## Endpoints
- GET /           → { message, status, version }
- GET /hello/{name} → { message, status }
- GET /actuator/health → health check
