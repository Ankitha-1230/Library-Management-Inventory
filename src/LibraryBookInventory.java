import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookInventory {

    // Stores all books in memory.
    // ArrayList is retained to keep the existing Week 3 tests compatible.
    static ArrayList<Book> books = new ArrayList<Book>();

    // Scanner is used to read input from the user.
    static Scanner scanner = new Scanner(System.in);

    // Constants avoid repeated hard-coded validation values.
    private static final int MIN_PUBLICATION_YEAR = 1000;
    private static final int MAX_PUBLICATION_YEAR = 2026;

    public static void main(String[] args) {

        int choice;

        // Menu continues until the user selects Exit.
        do {
            displayMenu();

            choice = readInt("Enter your choice: ");

            handleMenuChoice(choice);

        } while (choice != 5);

        scanner.close();
    }

    // Handles the user's menu selection.
    // This keeps the main method simple and improves readability.
    public static void handleMenuChoice(int choice) {

        switch (choice) {

            case 1:
                addBook();
                break;

            case 2:
                listBooks();
                break;

            case 3:
                updateBook();
                break;

            case 4:
                deleteBook();
                break;

            case 5:
                System.out.println(
                        "\nThank you for using Library Book Inventory System!"
                );
                break;

            default:
                System.out.println(
                        "\nInvalid choice! Please enter a number from 1 to 5."
                );
        }
    }

    // Displays the main menu.
    public static void displayMenu() {

        System.out.println("\n====================================");
        System.out.println("    LIBRARY BOOK INVENTORY SYSTEM");
        System.out.println("====================================");
        System.out.println("1. Add Book");
        System.out.println("2. List All Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Exit");
        System.out.println("====================================");
    }

    // CREATE - Adds a new book to the inventory.
    public static void addBook() {

        System.out.println("\n----- ADD BOOK -----");

        int id = readInt("Enter Book ID: ");

        // Validation is performed before creating the Book object.
        if (isBookIdExists(id)) {
            System.out.println(
                    "Book ID already exists! Please use a different ID."
            );
            return;
        }

        String title = readNonEmptyString("Enter Title: ");
        String author = readNonEmptyString("Enter Author: ");
        String isbn = readNonEmptyString("Enter ISBN: ");

        if (isIsbnExists(isbn)) {
            System.out.println(
                    "ISBN already exists! Please enter a different ISBN."
            );
            return;
        }

        int year = readPublicationYear();

        Book book = new Book(id, title, author, isbn, year);

        // Reuse the testable CRUD method instead of directly modifying
        // the collection. This follows the DRY principle.
        if (addBookToInventory(book)) {
            System.out.println("Book added successfully!");
        }
    }

    // READ - Displays all books.
    public static void listBooks() {

        System.out.println("\n----- ALL BOOKS -----");

        if (books.isEmpty()) {
            System.out.println("No books available in the inventory.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // UPDATE - Updates the details of an existing book.
    public static void updateBook() {

        System.out.println("\n----- UPDATE BOOK -----");

        int id = readInt("Enter Book ID to update: ");

        // Reuse findBookById() instead of writing another search loop.
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        String newTitle = readNonEmptyString("Enter New Title: ");
        String newAuthor = readNonEmptyString("Enter New Author: ");
        String newIsbn = readNonEmptyString("Enter New ISBN: ");

        // Prevent ISBN duplication.
        if (isIsbnUsedByAnotherBook(newIsbn, id)) {
            System.out.println(
                    "ISBN already belongs to another book!"
            );
            return;
        }

        int newYear = readPublicationYear();

        // Reuse the testable update method.
        if (updateBookDetails(
                id,
                newTitle,
                newAuthor,
                newIsbn,
                newYear)) {

            System.out.println("Book updated successfully!");
        }
    }

    // DELETE - Deletes a book from the inventory.
    public static void deleteBook() {

        System.out.println("\n----- DELETE BOOK -----");

        int id = readInt("Enter Book ID to delete: ");

        // Reuse deleteBookById() instead of duplicating the search loop.
        if (deleteBookById(id)) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    // Reads an integer safely and handles invalid input.
    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a valid number."
                );
            }
        }
    }

    // Reads a String and makes sure it is not empty.
    public static String readNonEmptyString(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty! Please try again."
            );
        }
    }

    // Reads and validates the publication year.
    // Constants are used instead of hard-coded values.
    public static int readPublicationYear() {

        while (true) {

            int year = readInt("Enter Publication Year: ");

            if (year >= MIN_PUBLICATION_YEAR
                    && year <= MAX_PUBLICATION_YEAR) {

                return year;
            }

            System.out.println(
                    "Invalid publication year! Enter a year between "
                    + MIN_PUBLICATION_YEAR + " and "
                    + MAX_PUBLICATION_YEAR + "."
            );
        }
    }

    // Checks whether a Book ID already exists.
    public static boolean isBookIdExists(int id) {

        return findBookById(id) != null;
    }

    // Checks whether an ISBN already exists.
    public static boolean isIsbnExists(String isbn) {

        for (Book book : books) {

            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }

        return false;
    }

    // Checks whether an ISBN belongs to another book.
    public static boolean isIsbnUsedByAnotherBook(
            String isbn, int currentBookId) {

        for (Book book : books) {

            if (book.getId() != currentBookId
                    && book.getIsbn().equalsIgnoreCase(isbn)) {

                return true;
            }
        }

        return false;
    }

    // Adds a book without requiring user input.
    // This method is reusable by both the application and unit tests.
    public static boolean addBookToInventory(Book book) {

        if (book == null) {
            return false;
        }

        if (isBookIdExists(book.getId())) {
            return false;
        }

        if (isIsbnExists(book.getIsbn())) {
            return false;
        }

        books.add(book);
        return true;
    }

    // Finds a book using its ID.
    // This method is reused by multiple operations to avoid duplicate code.
    public static Book findBookById(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    // Updates an existing book without user input.
    // Kept separate from the UI method for better modularity and testing.
    public static boolean updateBookDetails(
            int id,
            String title,
            String author,
            String isbn,
            int year) {

        Book book = findBookById(id);

        if (book == null) {
            return false;
        }

        if (isIsbnUsedByAnotherBook(isbn, id)) {
            return false;
        }

        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPublicationYear(year);

        return true;
    }

    // Deletes a book using its ID.
    // The same method is used by the UI and unit tests.
    public static boolean deleteBookById(int id) {

        Book book = findBookById(id);

        if (book == null) {
            return false;
        }

        books.remove(book);
        return true;
    }
}