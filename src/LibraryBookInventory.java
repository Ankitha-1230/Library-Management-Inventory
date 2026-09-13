import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookInventory {

    // ArrayList is used to store book objects in memory
    static ArrayList<Book> books = new ArrayList<Book>();

    // Scanner is used to take input from the user
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        // Menu will continue until the user selects Exit
        do {
            displayMenu();

            // Read menu choice safely
            choice = readInt("Enter your choice: ");

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
                    System.out.println("\nThank you for using Library Book Inventory System!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please enter a number from 1 to 5.");
            }

        } while (choice != 5);

        scanner.close();
    }

    // Displays the main menu
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

    // CREATE - Adds a new book to the inventory
    public static void addBook() {

        System.out.println("\n----- ADD BOOK -----");

        // Read and validate Book ID
        int id = readInt("Enter Book ID: ");

        // Check whether the Book ID already exists
        if (isBookIdExists(id)) {
            System.out.println("Book ID already exists! Please use a different ID.");
            return;
        }

        // Read book details
        String title = readNonEmptyString("Enter Title: ");
        String author = readNonEmptyString("Enter Author: ");
        String isbn = readNonEmptyString("Enter ISBN: ");

        // Check whether ISBN already exists
        if (isIsbnExists(isbn)) {
            System.out.println("ISBN already exists! Please enter a different ISBN.");
            return;
        }

        int year = readPublicationYear();

        // Create a new Book object
        Book book = new Book(id, title, author, isbn, year);

        // Add the book to ArrayList
        books.add(book);

        System.out.println("Book added successfully!");
    }

    // READ - Displays all books
    public static void listBooks() {

        System.out.println("\n----- ALL BOOKS -----");

        // Check whether the inventory is empty
        if (books.isEmpty()) {
            System.out.println("No books available in the inventory.");
            return;
        }

        // Display each book
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // UPDATE - Updates the details of an existing book
    public static void updateBook() {

        System.out.println("\n----- UPDATE BOOK -----");

        int id = readInt("Enter Book ID to update: ");

        // Search for the book using its ID
        for (Book book : books) {

            if (book.getId() == id) {

                String newTitle = readNonEmptyString("Enter New Title: ");
                String newAuthor = readNonEmptyString("Enter New Author: ");
                String newIsbn = readNonEmptyString("Enter New ISBN: ");

                // Check if the new ISBN belongs to another book
                if (isIsbnUsedByAnotherBook(newIsbn, id)) {
                    System.out.println("ISBN already belongs to another book!");
                    return;
                }

                int newYear = readPublicationYear();

                // Update book information
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setIsbn(newIsbn);
                book.setPublicationYear(newYear);

                System.out.println("Book updated successfully!");
                return;
            }
        }

        // If no book was found
        System.out.println("Book with ID " + id + " not found.");
    }

    // DELETE - Deletes a book from the inventory
    public static void deleteBook() {

        System.out.println("\n----- DELETE BOOK -----");

        int id = readInt("Enter Book ID to delete: ");

        // Search for the book
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getId() == id) {

                // Remove the book from ArrayList
                books.remove(i);

                System.out.println("Book deleted successfully!");
                return;
            }
        }

        // If no book was found
        System.out.println("Book with ID " + id + " not found.");
    }

    // Reads an integer safely and handles invalid input
    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    // Reads a String and makes sure it is not empty
    public static String readNonEmptyString(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty! Please try again.");
        }
    }

    // Reads and validates the publication year
    public static int readPublicationYear() {

        while (true) {

            int year = readInt("Enter Publication Year: ");

            // Basic validation for publication year
            if (year >= 1000 && year <= 2026) {
                return year;
            }

            System.out.println("Invalid publication year! Enter a year between 1000 and 2026.");
        }
    }

    // Checks whether a Book ID already exists
    public static boolean isBookIdExists(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return true;
            }
        }

        return false;
    }

    // Checks whether an ISBN already exists
    public static boolean isIsbnExists(String isbn) {

        for (Book book : books) {

            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }

        return false;
    }

    // Checks whether an ISBN belongs to another book
    public static boolean isIsbnUsedByAnotherBook(String isbn, int currentBookId) {

        for (Book book : books) {

            if (book.getId() != currentBookId &&
                book.getIsbn().equalsIgnoreCase(isbn)) {

                return true;
            }
        }

        return false;
    }
}