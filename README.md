# Employee Task Management System

A console-based Java application designed to manage employees and their assigned tasks using Core Java concepts such as OOP, Collections Framework, Exception Handling, Interfaces, and File I/O.

---

# Features

- Add and manage employees
- Assign tasks to employees
- Remove tasks from employees
- View all employees
- View assigned tasks
- Task status management using Enum
- File persistence using Java File I/O
- Custom exception handling
- Menu-driven console application
- Clean layered architecture

---

# Tech Stack

- Java
- OOP (Object-Oriented Programming)
- Collections Framework
- Exception Handling
- File I/O
- Git & GitHub

---

# Concepts Used

## OOP Concepts
- Classes & Objects
- Encapsulation
- Inheritance
- Polymorphism
- Interfaces

## Java Collections
- ArrayList
- HashMap
- List

## Exception Handling
- Custom Exceptions
- try-catch blocks

## File Handling
- FileWriter
- BufferedReader
- FileReader

---

# Project Structure

```text
TaskManagementSystem/
│
├── src/
│   │
│   ├── model/
│   │   ├── Employee.java
│   │   ├── Manager.java
│   │   ├── Task.java
│   │   └── TaskStatus.java
│   │
│   ├── repository/
│   │   └── EmployeeRepository.java
│   │
│   ├── service/
│   │   ├── Manageable.java
│   │   └── TaskService.java
│   │
│   ├── exception/
│   │   ├── EmployeeNotFoundException.java
│   │   └── TaskNotFoundException.java
│   │
│   ├── util/
│   │   └── FileUtil.java
│   │
│   └── Main.java
│
├── data/
│   └── employees.txt
│
├── README.md
└── .gitignore
```

---

# Functionalities

## Employee Management
- Add Employee
- Remove Employee
- Search Employee
- Display All Employees

## Task Management
- Assign Task
- Remove Task
- Display Employee Tasks
- Update Task Status

## File Persistence
- Save employee data into text file
- Load employee data on application startup

---

# Sample Menu

```text
========= Employee Task Management =========

1. Add Employee
2. View Employees
3. Assign Task
4. View Tasks
5. Remove Task
6. Save Data
7. Exit

Enter your choice:
```

---

# How to Run

## Clone Repository

```bash
git clone <your-github-repo-link>
```

---

## Navigate to Project

```bash
cd TaskManagementSystem
```

---

## Compile Java Files

```bash
javac src/model/*.java src/repository/*.java src/service/*.java src/exception/*.java src/util/*.java src/Main.java
```

---

## Run Application

```bash
java src/Main
```

---

# Git Commit History

```bash
Initial project setup

Added core model classes

Implemented employee repository using ArrayList

Added custom exception handling

Implemented task service using HashMap

Added file persistence functionality

Built console-based application menu

Final project cleanup and documentation
```

---

# Future Improvements

- Convert into Spring Boot REST API
- Add MySQL database integration
- Add Authentication & Authorization
- Build Frontend using React
- Dockerize application
- Convert into Microservices architecture

---

# Learning Outcomes

Through this project, I learned:

- Java OOP fundamentals
- Collections Framework usage
- Exception handling techniques
- File handling in Java
- Layered project architecture
- Git & GitHub workflow
- Clean coding practices

---

# Resume Description

**Employee Task Management System | Java, OOP, Collections, Exception Handling | GitHub**

- Built a console-based task management system in Java using OOP principles — Employee and Manager classes with inheritance, Manageable interface for task operations, and TaskStatus enum for state management.
- Implemented Collections layer using ArrayList for employee storage and HashMap<String, List<Task>> for task assignment; added custom exceptions (EmployeeNotFoundException) with structured error handling throughout.
- Persisted data using Java File I/O (FileWriter/BufferedReader); followed clean code practices with Javadoc comments and Git version control with meaningful commits.

---

# Author

Teja Dora