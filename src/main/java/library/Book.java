package library;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {

    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;
    private String borrowedBy;
    private LocalDate dueDate;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
        this.borrowedBy = null;
        this.dueDate = null;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBorrowedBy() { return borrowedBy; }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public LocalDate getDueDate() { return dueDate; }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isOverdue() {
        if (dueDate == null) return false;
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return String.format(
            "ISBN: %s | Title: %s | Author: %s | Year: %d | %s",
            isbn, title, author, year,
            available ? "Available" : "Borrowed by: " + borrowedBy
        );
    }
    public String toFileString() {
        return isbn + "," + title + "," + author + "," + year + "," + available + "," + borrowedBy;
    }
    public static Book fromFileString(String line) {

        String[] parts = line.split(",");

        Book book = new Book(
                parts[0],  // ISBN
                parts[1],  // Title
                parts[2],  // Author
                Integer.parseInt(parts[3]) // Year
        );

        book.setAvailable(Boolean.parseBoolean(parts[4]));

        if (!parts[5].equals("null")) {
            book.setBorrowedBy(parts[5]);
        }

        return book;
    }
}