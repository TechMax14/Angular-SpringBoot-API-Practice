# Angular-SpringBoot-API-Practice

This project serves as a practice and refresher for working with **RESTful APIs**, **Spring Boot**, and **Angular**. It demonstrates how to create an API backend with Spring Boot that interacts with a simple Angular front-end for displaying data, which in this case is **NFL player data**.

## Project Overview

The application provides two main functionalities:
1. **Filter NFL players by college** – Displays players based on the college they attended.
2. **Filter NFL players by position** – Displays players based on their position (e.g., Quarterback, Running Back).
3. **Combined filter** – Allows filtering by both college and position simultaneously.

This project demonstrates:
- **Spring Boot** for backend API development.
- **Angular** for frontend development.
- Integration of **RESTful API endpoints** with dynamic dropdowns.
  
### Key Features:
- A **Spring Boot API** that exposes endpoints to fetch player data based on **college** and **position**.
- A simple **Angular UI** with dropdowns for **college** and **position** filters.
- Sorting functionality for filtering players by one or both criteria.

## Project Screenshots

### 1. **College Filter Example**
   Here, the user can select a college (e.g., Alabama) to display all players from that college.

   ![Bama Example](https://raw.githubusercontent.com/TechMax14/Angular-SpringBoot-API-Practice/main/NFL-Angular-SpringBoot-API/BamaExample.PNG)

### 2. **Position Filter Example**
   Users can filter players based on their positions, such as Quarterbacks.

   ![QB Example](https://raw.githubusercontent.com/TechMax14/Angular-SpringBoot-API-Practice/main/NFL-Angular-SpringBoot-API/QBexample.PNG)

### 3. **Combined Filter Example**
   This example demonstrates filtering by both **college** and **position**, such as displaying Running Backs from Penn State.

   ![PSU RBS Example](https://raw.githubusercontent.com/TechMax14/Angular-SpringBoot-API-Practice/main/NFL-Angular-SpringBoot-API/PSUrbsExample.PNG)

## Technologies Used

- **Backend:**
  - **Spring Boot** – Used for creating RESTful APIs and managing the backend logic.
  - **Java** – Primary language for backend development.
  - **Spring Data JPA** – For database interaction (if applicable).
  
- **Frontend:**
  - **Angular** – Used for building the UI components and handling user interaction.
  - **TypeScript** – Main language used in Angular development.
  
- **Database:**
  - If you included a database for storing NFL player data, mention it here (e.g., MySQL, H2, etc.).

## API Endpoints

The Spring Boot API exposes the following endpoints:

1. **`GET /players/college/{collegeName}`**  
   - Retrieves all players from the specified college.
   - Example: `GET /players/college/Alabama`

2. **`GET /players/position/{position}`**  
   - Retrieves all players for the specified position.
   - Example: `GET /players/position/QB`

3. **`GET /players/college/{collegeName}/position/{position}`**  
   - Retrieves players from a specified college and position.
   - Example: `GET /players/college/Penn%20State/position/RB`

## Setup and Installation

### 1. Clone the repository
```bash
git clone https://github.com/TechMax14/Angular-SpringBoot-API-Practice.git
cd Angular-SpringBoot-API-Practice
