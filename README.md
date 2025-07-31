# SmartStudent

A console-based Student Management System built with Java, JDBC, and MySQL.

## Features
- Admin Login (Username: admin, Password: admin123)
- Add/View/Update/Delete Student Records
- Search Students by Department
- Statistics (optional)

## Technologies
- MySQL 8.x
- JDBC

## Setup
1. Run `student.sql` in MySQL to create the database and table.
2. Configure `DatabaseConnection.java` with your MySQL credentials.
3. Add the MySQL JDBC driver `.jar` to your project classpath.
4. Run `Main.java` to launch the app.

## Folder Structure
SmartStudent/
Main.java
DatabaseConnection.java
Student.java
StudentDAO.java
AdminService.java
UI.java
README.md
student.sql

