# URL Shortener Project

# Description
A full-stack URL shortener application with a Spring Boot backend and an Angular frontend.

# Project Structure
- `url-shortener-backend` - The Spring Boot backend service
- `url-shortener-frontend` - The Angular frontend application

# Prerequisites
- Java 17 (for backend)
- Node.js 18.x or higher (for frontend)
- Maven 3.6+ (for backend, if using Maven)
- Gradle (for backend, if using Gradle)
- Angular CLI 18.x (for frontend)

# Backend Setup

1. Navigate to the backend directory:
   ```
   cd url-shortener-backend
   ```

2. Build the backend project:
   ```
   ./mvnw clean install
   ```
   or
   ```
   ./gradlew build
   ```

3. Run the backend application:
   ```
   ./mvnw spring-boot:run
   ```
   or
   ```
   ./gradlew bootRun
   ```

4. Update `src/main/resources/application.properties` with your database credentials.

# Frontend Setup

1. Navigate to the frontend directory:
   ```
   cd url-shortener-frontend
   ```

2. Install frontend dependencies:
   ```
   npm install
   ```

3. Start the development server:
   ```
   npm start
   ```

4. The frontend application will be served at `http://localhost:4200`.

# Endpoints
- Backend: `POST /api/shorten` - Shorten a URL, `GET /api/{shortened}` - Redirect to the original URL.

# Testing
- Backend: Run tests with `./mvnw test` or `./gradlew test`.
- Frontend: Run tests with `npm test`.

# Deployment
- For deployment, ensure both backend and frontend are properly built and configured. Deploy backend to your preferred Java server and frontend to a static file server or platform.

# Additional Information
- Ensure MariaDB is running for the backend.
- Adjust configuration files for production environments as needed.
