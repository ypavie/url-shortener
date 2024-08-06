# URL Shortener Backend

# Description
A Spring Boot application for shortening URLs.

# Prerequisites
- Java 17
- Maven 3.6+ (if using Maven)
- Gradle (if using Gradle)

# Installation

1. Clone the repository:
   ```
   git clone https://your-repository-url.git
   ```

2. Navigate to the backend directory:
   ```
   cd url-shortener-backend
   ```

3. Build the project:
   ```
   ./mvnw clean install
   ```
   or
   ```
   ./gradlew build
   ```

4. Run the application:
   ```
   ./mvnw spring-boot:run
   ```
   or
   ```
   ./gradlew bootRun
   ```

# Configuration
- Update `src/main/resources/application.properties` with your database credentials:
   ```
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```

# Endpoints
- `POST /api/shorten` - Shorten a URL
- `GET /api/{shortened}` - Redirect to the original URL

# Testing
- Run unit tests:
   ```
   ./mvnw test
   ```
   or
   ```
   ./gradlew test
   ```

# Additional Information
- Ensure MariaDB is running and accessible at `jdbc:mariadb://localhost:3306/urlshortener`.
- The database schema will be automatically created or updated.
