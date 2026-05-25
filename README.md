# Employee Task Management System

A comprehensive **Core Java** project demonstrating Object-Oriented Programming principles, Collections Framework, File I/O, and Exception Handling.

---

## 📋 Features

✅ **Add Employees** - Create regular employees or managers  
✅ **View All Employees** - List all employees in the system  
✅ **Assign Tasks** - Assign tasks to employees  
✅ **View Tasks** - View all tasks assigned to an employee  
✅ **Remove Tasks** - Delete tasks from employee assignments  
✅ **File Persistence** - Save/Load employee data from file  
✅ **Exception Handling** - Custom exceptions with proper error messages  
✅ **Menu-Driven UI** - Easy-to-use console interface  

---

## 🏗️ Project Architecture

```
TaskManagementSystem/
│
├── src/
│   ├── model/
│   │   ├── Employee.java          (Base employee class)
│   │   ├── Manager.java           (Extends Employee)
│   │   ├── Task.java              (Task model)
│   │   └── TaskStatus.java        (Enum: PENDING, IN_PROGRESS, DONE)
│   │
│   ├── repository/
│   │   └── EmployeeRepository.java (ArrayList-based storage)
│   │
│   ├── service/
│   │   ├── Manageable.java        (Interface for task management)
│   │   └── TaskService.java       (HashMap-based task service)
│   │
│   ├── exception/
│   │   ├── EmployeeNotFoundException.java
│   │   └── TaskNotFoundException.java
│   │
│   ├── util/
│   │   └── FileUtil.java          (File I/O operations)
│   │
│   └── Main.java                  (Console application entry point)
│
├── data/
│   └── employees.txt              (Persistent storage)
│
├── README.md
├── .gitignore
└── LICENSE
```

---

## 🎯 Java Concepts Learned

| Concept | Implementation |
|---------|-----------------|
| **Classes & Objects** | Employee, Manager, Task models |
| **Constructors** | Parameter initialization in all classes |
| **Encapsulation** | Private fields with public getters/setters |
| **Inheritance** | Manager extends Employee (code reuse) |
| **Polymorphism** | TaskService implements Manageable interface |
| **Interfaces** | Manageable interface for contracts |
| **Enums** | TaskStatus (PENDING, IN_PROGRESS, DONE) |
| **Collections** | ArrayList (EmployeeRepository), HashMap (Task mapping) |
| **Exception Handling** | Custom exceptions + try-catch blocks |
| **File I/O** | FileWriter, BufferedWriter, FileReader, BufferedReader |
| **Loops & Conditionals** | while loop, switch statement, enhanced for-loop |
| **String Operations** | Split, equals, concatenation |

---

## 🚀 How to Run

### Prerequisites
- Java JDK 8 or higher
- Git (for version control)

### Compilation

```bash
# Navigate to project root
cd TaskManagementSystem

# Compile all Java files
javac -d . src/model/*.java src/repository/*.java src/exception/*.java src/service/*.java src/util/*.java src/Main.java
```

### Execution

```bash
# Run the application
java Main
```

---

## 📖 Usage Guide

### Menu Options

```
1. Add Employee
   - Enter Employee ID, Name, Department
   - Choose: Regular Employee or Manager
   - If Manager: Enter Team Size

2. View All Employees
   - Displays all employees with their details
   - Shows: ID, Name, Department, Type, Team Size (if Manager)

3. Assign Task
   - Enter Employee ID
   - Create Task: ID, Title, Description
   - Task automatically set to PENDING status

4. View Tasks
   - Shows all tasks assigned to employee
   - Displays: Task ID, Title, Description, Status

5. Remove Task
   - Enter Employee ID and Task ID
   - Task is removed from assignments

6. Save Data
   - Writes all employees to data/employees.txt
   - Enables data persistence across sessions

7. Exit
   - Saves and closes application
```

---

## 📊 Data Storage Format

### employees.txt
```
E101,Teja,Engineering,Employee,0
E102,Priya,HR,Manager,5
E103,Rajesh,Sales,Employee,0
```

Format: `employeeId,name,department,type,teamSize`

---

## 🔑 Key Design Patterns

### 1. **Repository Pattern** (EmployeeRepository)
- Abstracts data access layer
- ArrayList for in-memory storage
- Methods: addEmployee, removeEmployee, findEmployeeById, displayEmployees

### 2. **Service Pattern** (TaskService)
- Business logic layer
- HashMap for efficient task lookups
- Implements Manageable interface

### 3. **Exception Handling** 
- Custom exceptions for domain errors
- Try-catch blocks for error recovery
- User-friendly error messages

### 4. **Inheritance & Polymorphism**
- Manager extends Employee
- Overridden toString() method
- Code reuse through super()

---

## 📚 Learning Path

### Phase 1: Basics (Commits 1-2)
- Project setup with Git
- Model classes with OOP principles
- Encapsulation, constructors, getters/setters

### Phase 2: Collections (Commit 3)
- ArrayList implementation
- Object storage and retrieval
- Iteration patterns

### Phase 3: Advanced OOP (Commit 4-5)
- Custom exceptions
- Interface implementation
- HashMap for complex data structures

### Phase 4: Persistence & UI (Commit 6-7)
- File I/O operations
- Menu-driven application
- Complete user experience

### Phase 5: Polish (Commit 8)
- Code documentation
- Production-ready error handling
- README and best practices

---

## 💡 Interview Questions You Can Answer

After completing this project, you should understand:

1. **What is inheritance and why use it?**  
   → Manager extends Employee to reuse code

2. **Difference between ArrayList and HashMap?**  
   → ArrayList: ordered, indexed access  
   → HashMap: key-value pairs, fast lookup

3. **What are custom exceptions?**  
   → Domain-specific exception classes extending Exception

4. **How does interface work in Java?**  
   → Manageable defines contract, TaskService implements it

5. **What is encapsulation?**  
   → Private fields + public getters/setters = controlled access

6. **Explain polymorphism in your project**  
   → TaskService (implements Manageable) can be used as Manageable type

7. **File I/O in your project?**  
   → FileWriter/BufferedWriter for save, FileReader/BufferedReader for load

---

## 🎓 Tech Stack

| Technology | Usage |
|-----------|-------|
| **Java** | Core language |
| **OOP** | Design principles |
| **Collections** | ArrayList, HashMap |
| **File I/O** | Data persistence |
| **Git & GitHub** | Version control |
| **Console UI** | Scanner-based menu |

---

## 📝 Git Commit History

```
COMMIT 1: Initial project setup
COMMIT 2: Added core model classes
COMMIT 3: Implemented employee repository using ArrayList
COMMIT 4: Added custom exception handling
COMMIT 5: Implemented task service using HashMap
COMMIT 6: Added file persistence functionality
COMMIT 7: Built console-based application menu
COMMIT 8: Final project cleanup and documentation
```

---

## ✨ Future Enhancements

- Convert to Swing/JavaFX GUI
- Add database persistence (JDBC, JPA)
- Implement Spring Boot framework
- Add email notifications
- Deploy as web application
- Add REST API with Spring

---

## 📞 How to Contribute

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit changes (`git commit -m 'Add YourFeature'`)
4. Push to branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see LICENSE file for details.

---

## 👥 Author

**Your Name** - Core Java Developer  
GitHub: [Your GitHub Profile]

---

## 🙏 Acknowledgments

- Java Fundamentals & OOP Principles
- Collections Framework Documentation
- Exception Handling Best Practices
- Clean Code Principles

---

**Happy Coding! 🚀**
