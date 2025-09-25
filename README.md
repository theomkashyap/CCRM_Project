# Campus Course & Records Manager (CCRM)

## Project Overview
**CCRM** is a console-based **Java SE** application designed to help institutes manage academic data efficiently.  
It demonstrates modern Java programming concepts while providing a complete workflow for student, course, and grade management.

### What CCRM Can Do
- **Student Management:** Add, update, list, or deactivate students; view profiles and transcripts.  
- **Course Management:** Add, update, list, deactivate courses; assign instructors; search/filter courses.  
- **Enrollment & Grading:** Enroll/unenroll students with business rules; record marks, compute GPA, and generate transcripts.  
- **File Utilities:** Import/export data (CSV/JSON-like text files) and backup course data with timestamped folders.  

The application demonstrates **OOP principles, exception handling, NIO.2, Streams, Date/Time API, interfaces, abstract/nested classes, enums, lambdas, recursion, and design patterns (Singleton & Builder).**

---

## Functional Requirements

### 1. Student Management
- Fields: `id`, `regNo`, `fullName`, `email`, `status`, `enrolledCourses`, `date fields (Java Date/Time API)`.  
- Actions: Add/list/update/deactivate students, print profiles and transcripts.

### 2. Course Management
- Fields: `code`, `title`, `credits`, `instructor`, `semester`, `department`.  
- Actions: Add/list/update/deactivate courses, search/filter by instructor, department, semester using **Streams API**.

### 3. Enrollment & Grading
- Enroll/unenroll students with **business rules** (e.g., max credits per semester).  
- Record marks, compute letter grades and GPA.  
- Enums: `Semester` (SPRING, SUMMER, FALL) and `Grade` (S, A, B, …, F with grade points).  
- Transcripts use **polymorphism** and `toString()` overrides for display.

### 4. File Operations
- Import students/courses from CSV-like files.  
- Export current data and backup in **timestamped folders** using NIO.2 (`Path`, `Files`, `walk`, `copy`, `move`).  
- Recursive utilities: compute backup folder size or list files by depth.  

### 5. CLI Workflow
- Menu-driven console using **switch** and loop constructs (`while`, `do-while`, `for`, `enhanced-for`).  
- Includes `break`, `continue`, and a **labeled jump** once.  

---

## Technical Highlights

### Java Setup & Architecture
- **Evolution of Java:**  
  - 1995: Java 1.0 released  
  - 1998: J2SE 1.2 (Collections Framework)  
  - 2004: J2SE 5.0 (Generics, Enums, Annotations)  
  - 2014: Java SE 8 (Lambda, Stream API, Date/Time API)  
  - 2018: Java SE 11 (LTS)  
  - 2021: Java SE 17 (LTS, Sealed Classes)  

- **Java ME vs SE vs EE:**  

| Platform | Target | Use Case |
|----------|--------|----------|
| ME | Resource-constrained devices | IoT, legacy mobile apps |
| SE | Desktop/Server/Console | General-purpose apps (this project) |
| EE | Large-scale enterprise | Web servers, JSP, Servlets |

- **JDK vs JRE vs JVM:**  
  - **JDK:** Compile and develop Java apps  
  - **JRE:** Run Java bytecode  
  - **JVM:** Executes bytecode, making Java platform-independent  

---

### Language & Core Features
- Packages: `edu.ccrm.domain`, `edu.ccrm.service`, `edu.ccrm.io`, `edu.ccrm.util`, `edu.ccrm.cli`, `edu.ccrm.config`  
- Demonstrated Java constructs:
  - Primitives, objects, operators, operator precedence  
  - Decision structures (`if`, `if-else`, nested, `switch`)  
  - Loops (`while`, `do-while`, `for`, `enhanced-for`)  
  - Arrays & Arrays utilities (`sort`, `toString`)  
  - Strings (`substring`, `split`, `join`, `equals`, `compareTo`)  

---

### OOP Concepts
- **Encapsulation:** Private fields + getters/setters  
- **Inheritance:** `Person` → `Student` & `Instructor`  
- **Abstraction:** Abstract `Person` class with abstract methods  
- **Polymorphism:** Base-class references invoke subclass methods  

- **Access Levels:** Private, Protected, Default, Public  
- **Immutable Classes:** Example: `Name` or `CourseCode` with `final` fields  
- **Nested Classes:** One static nested class, one inner class  
- **Interfaces:** `Persistable`, `Searchable<T>` with default and overridden methods  
- **Functional Interfaces & Lambdas:** Sorting, filtering  
- **Anonymous Inner Classes:** CLI callback or quick strategy  
- **Enums:** `Semester`, `Grade` with fields and constructors  

---

### Advanced Concepts
- Upcast & downcast, `instanceof` checks  
- Overriding & overloading methods  
- `toString()` overrides in domain classes  
- **Design Patterns:** Singleton (`AppConfig`), Builder (`Course.Builder`)  
- **Exceptions:** Checked/Unchecked, Custom (`DuplicateEnrollmentException`, `MaxCreditLimitExceededException`), try/catch/multi-catch/finally/throw/throws  
- **Assertions:** Internal invariants, enabled with `-ea` VM argument  
- **File I/O (NIO.2 + Streams):** Import/export, backup, file traversal  
- **Date/Time API:** Enrollment dates, backup folder timestamps  

---

## Suggested Package Structure
