# sauce-petgolden-automation

## Automated Technical Test - PetsGolden

### Overview

This project is an automated testing suite designed to validate the functionality of the PetsGolden web application and its API endpoints. The automation tests are implemented using Java, Selenium WebDriver for web UI testing, and Cucumber for behavior-driven development (BDD) style test scenarios. The API tests leverage Spring (if applicable) to perform integration testing on RESTful services.

### Technology Stack

- Java 17+
- Selenium WebDriver
- Cucumber JVM
- Spring Boot (optional, for API testing)
- Maven (for build and dependency management)
- JUnit/TestNG (test runner)
- REST Assured or HTTP client (for API calls)
- Git for version control

### Features Tested

#### Web & UI Tests
- User authentication and login/logout workflows
- Navigation across key pages of the PetsGolden website
- Form input validation and error message handling
- CRUD operations on user profiles or pets (depending on app scope)
- Validation of UI elements and dynamic content loading

#### API Tests
- Endpoint validation for user management (Create, Read, Update, Delete)
- Response status codes and payload verification
- Modular validation of response messages and fields
- Edge cases and negative test scenarios such as deleting non-existent users

### Highlights
- Modular and reusable validation methods for API response fields
- Cucumber feature files for readable and collaborative test scenarios
- Avoidance of personal data in test cases (no real user names)
- Tests structured to run sequentially or independently for CI/CD integration

### How to Run

- Clone the repository
- Install Java and Maven on your machine
- Run the following command to execute tests **(only one test type at a time)**:

```bash
# Run Web tests 
mvn clean test -Dtest=com.petsgolden.runner.UITest

# Run API tests 
mvn clean test -Dtest=com.petsgolden.runner.APITest