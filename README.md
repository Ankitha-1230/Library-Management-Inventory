# Library Book Inventory System

## Project Description

The Library Book Inventory System is a Java-based command-line application developed to manage books in a library inventory.

The application allows users to perform basic CRUD operations:

- Add a new book
- View all books
- Update book details
- Delete a book

Book information includes:

- Book ID
- Title
- Author
- ISBN
- Publication Year

The application stores book data in memory using Java ArrayList.

## Technologies Used

- Java
- Java ArrayList
- Java Scanner
- JUnit 4.13.2
- Command Line Interface
- VS Code

## Features

### 1. Add Book

Allows the user to add a new book with its ID, title, author, ISBN, and publication year.

### 2. List All Books

Displays all books currently stored in the inventory.

### 3. Update Book

Allows the user to update the details of an existing book using its Book ID.

### 4. Delete Book

Allows the user to delete a book using its Book ID.

### 5. Input Validation

The application validates user input and prevents invalid values.

### 6. Exception Handling

NumberFormatException is handled when the user enters invalid numeric input.

### 7. Duplicate Checking

The application checks for duplicate Book IDs and ISBN values.

## Week 3 - Unit Testing and Debugging

JUnit 4.13.2 was used to test the core functionality of the inventory system.

The test suite contains 11 test cases covering:

- Create operation
- Read operation
- Update operation
- Delete operation
- Book not found scenarios
- Duplicate Book ID
- Duplicate ISBN
- Duplicate ISBN during update
- Case-insensitive ISBN checking

An intentional bug was introduced in the delete operation by changing the ID comparison condition. The JUnit test detected the error, and the condition was corrected.

Final Week 3 test result:

- Total tests: 11
- Passed: 11
- Failed: 0

## Week 4 - Code Refactoring and Optimization

In Week 4, the Library Book Inventory Management System was refactored to improve code readability, maintainability, and structure while preserving the existing functionality.

### Refactoring Improvements

- Applied the DRY (Don't Repeat Yourself) principle.
- Reused `findBookById()` instead of repeating book search logic.
- Reused `deleteBookById()` in the delete operation.
- Added constants for publication year validation.
- Added `handleMenuChoice()` to keep the `main()` method simple and modular.
- Separated user-input handling from core inventory operations.
- Removed temporary debugging code from Week 3.
- Added comments explaining important refactoring decisions.

### Testing After Refactoring

The existing JUnit test suite was executed after the refactoring to verify that the changes did not break the application.

Final Week 4 test result:

- JUnit version: 4.13.2
- Total tests: 11
- Passed: 11
- Failed: 0

## Run the Application

### Compile

```text
javac -d bin src\Book.java src\LibraryBookInventory.java