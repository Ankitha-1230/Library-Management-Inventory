public class Book {

    // Book properties
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    // Constructor to initialize a book
    public Book(int id, String title, String author, String isbn, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for Title
    public String getTitle() {
        return title;
    }

    // Setter for Title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for Author
    public String getAuthor() {
        return author;
    }

    // Setter for Author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for ISBN
    public String getIsbn() {
        return isbn;
    }

    // Setter for ISBN
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Getter for Publication Year
    public int getPublicationYear() {
        return publicationYear;
    }

    // Setter for Publication Year
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Converts book details into a readable format
    @Override
    public String toString() {
        return "ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | ISBN: " + isbn +
                " | Publication Year: " + publicationYear;
    }
}