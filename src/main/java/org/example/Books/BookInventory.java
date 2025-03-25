package org.example.Books;

import java.util.*;
public class BookInventory {
    private List<Book> availableBooks;

    public BookInventory() {
        this.availableBooks = new ArrayList<>();
    }

    // Track book availability
    public void trackInventory(Book book, boolean isAvailable) {
        if (isAvailable) {
            availableBooks.add(book);
        } else {
            availableBooks.remove(book);
        }
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }
}
