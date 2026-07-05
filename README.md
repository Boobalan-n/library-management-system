# Library Management System — Core Java | OOP | Exception Handling

A console-based Library Management System built with Core Java, demonstrating
**OOP principles** (inheritance, encapsulation, polymorphism), collections, and
robust exception handling.

## ✨ Features
- Add books, register members, view catalogs — all through a menu-driven console UI.
- **Borrow / Return workflow** with real business rules: can't borrow a book with
  0 copies left, can't return a book you never borrowed.
- **Inheritance & Polymorphism**: `Book` extends abstract `LibraryItem` and overrides
  `displayInfo()`.
- **Encapsulation**: all fields are private with controlled getters/setters.
- **Custom checked exceptions** (`InvalidIdException`, `BookNotAvailableException`)
  instead of generic `Exception` — makes error handling explicit and testable.
- Uses `ArrayList` for dynamic in-memory storage of books and members.
- Comes pre-loaded with sample data so it runs immediately, no setup needed.

## 🗂️ Project Structure
```
library-management-system/
└── src/
    ├── Main.java                     # Menu-driven entry point
    ├── Library.java                  # Core logic: catalog, borrow/return workflow
    ├── LibraryItem.java              # Abstract base class
    ├── Book.java                     # Extends LibraryItem
    ├── Member.java                   # Library member + their borrowed books
    ├── BookNotAvailableException.java
    └── InvalidIdException.java
```

## ▶️ How to Run
1. Install **JDK 11+**.
2. Clone the repo:
   ```
   git clone https://github.com/Boobalan-n/library-management-system.git
   cd library-management-system/src
   ```
3. Compile and run:
   ```
   javac *.java
   java Main
   ```
4. Try it out: view books (option 1), borrow B003 (only 1 copy) as M001, then try
   borrowing it again as M002 — you'll see `BookNotAvailableException` handled gracefully.

## 🧰 Tech Stack
Core Java · OOP (Inheritance, Encapsulation, Polymorphism, Abstraction) ·
Collections (ArrayList) · Custom Exception Handling
