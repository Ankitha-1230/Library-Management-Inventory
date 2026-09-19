# Library Book Inventory System - Week 5

## 1. Project Overview

The Library Book Inventory System is a Java-based command-line application developed to manage basic library book records.

The project was developed and improved over multiple weeks as part of the Java internship tasks. In Week 5, the application was integrated, tested, packaged as a JAR file, and prepared for simple deployment using Windows batch scripts.

The application allows the user to add, view, update, and delete book records. It also includes input validation and checks for duplicate Book IDs and ISBNs.

The current version stores book information temporarily using an ArrayList. No database is used.

## 2. Features

* Add a new book
* List all books
* Update book details
* Delete a book
* Validate Book ID
* Prevent duplicate Book IDs
* Prevent duplicate ISBNs
* Validate publication year
* Handle invalid numeric input
* JUnit unit testing
* Executable JAR packaging
* Simple deployment scripts

## 3. Technologies Used

* Java 8
* ArrayList
* JUnit 4.13.2
* Hamcrest 1.3
* VS Code
* Windows PowerShell / Command Prompt

## 4. Project Structure

```text
Library_Management_Inventory_Week5
│
├── src
│   ├── Book.java
│   └── LibraryBookInventory.java
│
├── test
│   └── LibraryBookInventoryTest.java
│
├── lib
│   ├── junit-4.13.2.jar
│   └── hamcrest-core-1.3.jar
│
├── deployment
│   ├── build.bat
│   └── run.bat
│
├── build
│
├── dist
│   └── LibraryBookInventory.jar
│
└── README.md
```

## 5. How to Compile

Open PowerShell in the Week 5 project folder and run:

```text
javac -d build src\Book.java src\LibraryBookInventory.java
```

This compiles the Java source files and stores the generated class files inside the `build` folder.

## 6. How to Run

After compiling the source files, run the application using:

```text
java -cp build LibraryBookInventory
```

The application displays a menu with options to add, list, update, delete, or exit.

## 7. How to Create the JAR

The executable JAR can be created using:

```text
jar cfe dist\LibraryBookInventory.jar LibraryBookInventory -C build .
```

The generated JAR file will be stored in:

```text
dist\LibraryBookInventory.jar
```

The JAR can then be executed using:

```text
java -jar dist\LibraryBookInventory.jar
```

## 8. Deployment Scripts

Two simple Windows batch scripts are included in the `deployment` folder.

### build.bat

The `build.bat` script compiles the Java source files and creates the executable JAR file.

Run it using:

```text
deployment\build.bat
```

### run.bat

The `run.bat` script checks whether the JAR file exists and then starts the application using `java -jar`.

Run it using:

```text
deployment\run.bat
```

If the JAR file does not exist, the script asks the user to run `build.bat` first.

These scripts are provided to simplify the build and execution process. They are part of the Week 5 deployment preparation and do not represent production deployment.

## 9. Testing

JUnit 4.13.2 is used for unit testing.

The project contains 11 existing test cases covering important operations such as:

* Adding books
* Finding books
* Updating books
* Deleting books
* Book not found cases
* Duplicate Book ID
* Duplicate ISBN
* Duplicate ISBN during update
* Case-insensitive ISBN validation

The integrated Week 5 project was tested using JUnit.

All 11 tests passed successfully.

Expected result:

```text
OK (11 tests)
```

The required JUnit libraries are stored in the `lib` folder.

## 10. Future Enhancements

The current application is a basic command-line inventory system. Possible future improvements include:

* Database integration
* Web-based user interface
* Search and filtering features
* User authentication
* Better reporting features
* Maven or Gradle build management
* Automated testing and deployment

These features are possible future enhancements and are not included in the current Week 5 implementation.

## Conclusion

Week 5 focused on integrating the Library Book Inventory System, testing the integrated application, packaging it as an executable JAR, and preparing simple deployment scripts.

The project now contains the Java source files, JUnit tests, required libraries, deployment scripts, executable JAR, and project README.

The application is intended as a student Java project and the deployment scripts are used to demonstrate the basic build and execution process.
