# QueryMethods

# Student Model API

## Model
- Student
<br><br>

## Controller
- StudentController
<br><br>

## Repository
- StudentRepository
- Queries
- 1. @Query(value = "select * from student where first_name = :first_name", nativeQuery = true)
- 2. @Query(value = "select * from student where last_name = :lastName", nativeQuery = true)
- 3. @Query(value = "select * from student where age = :age", nativeQuery = true)
- 4. @Query(value = "select * from student where active = :active", nativeQuery = true)
<br><br>

## Service
- StudentService
<br><br>

## Database
- MySQL
<br><br>

## Project Summary
- In this project we are performing the operation using native Query and retriving the data from DataBase
<br><br>

- PostMapping -> http://localhost:8080/api/v1/postStudent

- GetMapping - > http://localhost:8080/api/v1/getStudentByFirstName (By firstName)

- GetMapping - > http://localhost:8080/api/v1/getStudentByLastName (By lastName)

- GetMapping - > http://localhost:8080/api/v1/getStudentByAge (By Age)

- GetMapping - > http://localhost:8080/api/v1/getStudentByActiveness (By active)
