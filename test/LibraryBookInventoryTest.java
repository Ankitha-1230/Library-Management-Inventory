import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LibraryBookInventoryTest {

    // Clear the inventory before every test
    @Before
    public void setUp() {
        LibraryBookInventory.books.clear();
    }

    // Test CREATE operation
    @Test
    public void testAddBook() {

        Book book = new Book(
                101,
                "Java Programming",
                "James Gosling",
                "ISBN101",
                2024
        );

        boolean result = LibraryBookInventory.addBookToInventory(book);

        assertTrue(result);
        assertEquals(1, LibraryBookInventory.books.size());
    }

    // Test READ operation
    @Test
    public void testFindBookById() {

        Book book = new Book(
                102,
                "Python Basics",
                "Guido",
                "ISBN102",
                2023
        );

        LibraryBookInventory.addBookToInventory(book);

        Book foundBook = LibraryBookInventory.findBookById(102);

        assertNotNull(foundBook);
        assertEquals("Python Basics", foundBook.getTitle());
        assertEquals("Guido", foundBook.getAuthor());
    }

    // Test READ operation when book does not exist
    @Test
    public void testFindBookNotFound() {

        Book foundBook = LibraryBookInventory.findBookById(999);

        assertNull(foundBook);
    }

    // Test UPDATE operation
    @Test
    public void testUpdateBook() {

        Book book = new Book(
                103,
                "Old Title",
                "Old Author",
                "ISBN103",
                2020
        );

        LibraryBookInventory.addBookToInventory(book);

        boolean result = LibraryBookInventory.updateBookDetails(
                103,
                "New Title",
                "New Author",
                "ISBN103NEW",
                2025
        );

        assertTrue(result);

        Book updatedBook = LibraryBookInventory.findBookById(103);

        assertEquals("New Title", updatedBook.getTitle());
        assertEquals("New Author", updatedBook.getAuthor());
        assertEquals("ISBN103NEW", updatedBook.getIsbn());
        assertEquals(2025, updatedBook.getPublicationYear());
    }

    // Test UPDATE when book does not exist
    @Test
    public void testUpdateBookNotFound() {

        boolean result = LibraryBookInventory.updateBookDetails(
                999,
                "New Title",
                "New Author",
                "ISBN999",
                2025
        );

        assertFalse(result);
    }

    // Test DELETE operation
    @Test
    public void testDeleteBook() {

        Book book = new Book(
                104,
                "C Programming",
                "Dennis Ritchie",
                "ISBN104",
                2022
        );

        LibraryBookInventory.addBookToInventory(book);

        boolean result = LibraryBookInventory.deleteBookById(104);

        assertTrue(result);
        assertEquals(0, LibraryBookInventory.books.size());
    }

    // Test DELETE when book does not exist
    @Test
    public void testDeleteBookNotFound() {

        boolean result = LibraryBookInventory.deleteBookById(999);

        assertFalse(result);
    }

    // Test duplicate Book ID
    @Test
    public void testDuplicateBookId() {

        Book firstBook = new Book(
                105,
                "Book One",
                "Author One",
                "ISBN105",
                2024
        );

        Book secondBook = new Book(
                105,
                "Book Two",
                "Author Two",
                "ISBN106",
                2025
        );

        assertTrue(
                LibraryBookInventory.addBookToInventory(firstBook)
        );

        assertFalse(
                LibraryBookInventory.addBookToInventory(secondBook)
        );
    }

    // Test duplicate ISBN
    @Test
    public void testDuplicateIsbn() {

        Book firstBook = new Book(
                106,
                "Book One",
                "Author One",
                "ISBN-SAME",
                2024
        );

        Book secondBook = new Book(
                107,
                "Book Two",
                "Author Two",
                "ISBN-SAME",
                2025
        );

        assertTrue(
                LibraryBookInventory.addBookToInventory(firstBook)
        );

        assertFalse(
                LibraryBookInventory.addBookToInventory(secondBook)
        );
    }

    // Test updating with an ISBN already used by another book
    @Test
    public void testUpdateWithDuplicateIsbn() {

        Book firstBook = new Book(
                108,
                "Book One",
                "Author One",
                "ISBN108",
                2024
        );

        Book secondBook = new Book(
                109,
                "Book Two",
                "Author Two",
                "ISBN109",
                2025
        );

        LibraryBookInventory.addBookToInventory(firstBook);
        LibraryBookInventory.addBookToInventory(secondBook);

        boolean result = LibraryBookInventory.updateBookDetails(
                108,
                "Updated Book",
                "Updated Author",
                "ISBN109",
                2026
        );

        assertFalse(result);
    }

    // Test case-insensitive ISBN checking
    @Test
    public void testIsbnCaseInsensitive() {

        Book book = new Book(
                110,
                "Java",
                "Author",
                "ISBN110",
                2024
        );

        LibraryBookInventory.addBookToInventory(book);

        assertTrue(
                LibraryBookInventory.isIsbnExists("isbn110")
        );
    }
}