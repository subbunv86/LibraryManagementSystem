package org.example.Patrons;

import org.example.Books.Book;

import java.util.*;

public class Patron {
    private String name;
    private String id;
    private List<Book> borrowedBooks;

    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getPatronName() {
        return name;
    }
    // Add a borrowed book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Return a borrowed book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Get borrowed books list
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}

