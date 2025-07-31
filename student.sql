DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    roll_no VARCHAR(50) UNIQUE,
    department VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(15),
    marks INT
);


