package org.example.Library;

import org.example.Books.Book;
import org.example.Patrons.Patron;

public class LendBook {
    private Library inventory;

    public LendBook(Library inventory) {
        this.inventory = inventory;
    }

    // Checkout a book
    public void checkoutBook(Patron patron, String ISBN) {
        Book book = findBookByISBN(ISBN);
        if (book != null) {
            patron.borrowBook(book);
            inventory.removeBook(ISBN);
            System.out.println("Book checked out: " + book);
        } else {
            System.out.println("Book not available.");
        }
    }

    // Return a book
    public void returnBook(Patron patron, String ISBN) {
        Book book = findBookByISBN(ISBN);
        if (book != null) {
            patron.returnBook(book);
            inventory.addBook(book);
            System.out.println("Book returned: " + book);
        } else {
            System.out.println("Book not found in patron's borrowed books.");
        }
    }

    // Helper method to find book by ISBN
    private Book findBookByISBN(String ISBN) {
        for (Book book : inventory.getBooks()) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }
}

