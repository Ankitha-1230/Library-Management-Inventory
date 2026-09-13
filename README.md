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

## Project Structure

```text
Library_Management_Inventory
│
├── src
│   ├── Book.java
│   └── LibraryBookInventory.java
│
├── bin
├── report
└── README.md