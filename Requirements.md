# CCRM Project Requirements

## Overview
The **Campus Course & Records Manager (CCRM)** is a console-based Java SE application designed to help institutes efficiently manage students, courses, and academic records.  

It should provide a complete workflow for **student management, course management, enrollment & grading**, and **file operations** such as import, export, and backup. The system is built with modern Java practices and demonstrates **OOP, exception handling, NIO.2, Streams, Date/Time API, enums, lambdas, recursion, and design patterns**.

---

## Functional Requirements

### 1. Student Management
The system must allow the user to:  
- **Add, list, update, or deactivate students**  
- Store the following student details:
  - `id`, `regNo`, `fullName`, `email`, `status`  
  - `enrolledCourses` (list of course codes)  
  - Dates (using Java Date/Time API)  
- **Print student profiles** and **transcripts**

### 2. Course Management
Users should be able to:  
- **Add, list, update, or deactivate courses**  
- Each course should include:
  - `code`, `title`, `credits`, `instructor`, `semester`, `department`  
- **Search & filter courses** by instructor, department, or semester (using Streams API)  

### 3. Enrollment & Grading
- Enroll or unenroll students in courses while enforcing **business rules** (e.g., maximum credits per semester)  
- Record marks and automatically compute **letter grades and GPA**  
- Use **enums** for `Semester` (SPRING, SUMMER, FALL) and `Grade` (S, A, B…F with grade points)  
- Display transcripts using **polymorphism** and `toString()` overrides  

### 4. File Operations
- Import students and courses from CSV-like text files  
- Export current data (students, courses, enrollments) to CSV files  
- Backup exported data to a **timestamped folder** using NIO.2 (`Path`, `Files`, `walk`, `copy`, `move`)  
- Include a **recursive utility** to calculate backup folder size or list files by depth  

### 5. CLI Workflow
- Menu-driven console with options for all operations:  
  - Manage Students / Courses / Enrollment / Grades  
  - Import/Export Data  
  - Backup & Show Backup Size  
  - Reports (e.g., top students, GPA distribution)  
  - Exit  
- Use **switch statements** and all loop/decision constructs (`while`, `do-while`, `for`, `enhanced-for`)  
- Include at least one **jump control**: `break`, `continue`, or a labeled jump  

---

## Technical Requirements

### Java & Platform
- **Java SE 17 or higher**  
- IDE: **Eclipse** or **VS Code with Java extensions**  
- Enable **assertions** (`-ea`) for internal consistency checks  

### Code Organization
- Packages:
  - `edu.ccrm.domain` → Student, Instructor, Course, Enrollment, enums, immutable value objects  
  - `edu.ccrm.service` → Services for managing students, courses, enrollment, and transcripts  
  - `edu.ccrm.io` → Import/Export services, backup services, CSV parsers  
  - `edu.ccrm.util` → Validators, comparators, recursion utilities  
  - `edu.ccrm.cli` → Menu and input handling  
  - `edu.ccrm.config` → Singleton `AppConfig`, builders  

### Object-Oriented Programming
- **Encapsulation:** Private fields + getters/setters  
- **Inheritance:** `Person` (abstract) → `Student`, `Instructor`  
- **Abstraction:** Abstract `Person` class with abstract methods  
- **Polymorphism:** Base-class references call subclass methods  

### Advanced Java Concepts
- **Interfaces:** e.g., `Persistable`, `Searchable<T>`  
- **Enums:** `Semester`, `Grade` with constructors and fields  
- **Lambdas & Functional Interfaces:** Sorting and filtering  
- **Anonymous Inner Classes:** Used once for CLI callback or quick strategy  
- **Design Patterns:** Singleton (`AppConfig`) and Builder (`Course.Builder`)  
- **Exceptions:** Custom exceptions (e.g., `DuplicateEnrollmentException`, `MaxCreditLimitExceededException`), try/catch/finally, assertions  
- **File I/O (NIO.2 + Streams):** Import, export, backup, and file traversal  
- **Date/Time API:** Enrollment dates, backup folder timestamps  

---

## Deliverables
1. Fully implemented **Java SE console application**  
2. **Git repository** containing:  
   - Source code and runnable main class  
   - `README.md` with project overview, setup instructions, Java evolution, and package mapping  
   - Screenshots of:
     - JDK installation  
     - IDE setup & project run  
     - Sample program operations  
     - Export/Backup folder structure  
   - Optional demo video link  
3. Sample **CSV files** for test data  
4. Optional **Usage.md** for sample commands  

---

## Notes
- The system should be **modular, maintainable, and robust**  
- Demonstrate **all core and advanced Java concepts** in a meaningful way  
- Follow **academic integrity**: work must be your own, cite references if used  

