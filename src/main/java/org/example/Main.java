package org.example;
import org.example.Books.Book;
import org.example.Books.BookInventory;
import org.example.Library.LendBook;
import org.example.Library.Library;
import org.example.Patrons.Patron;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the LibraryInventory to manage books
        Library library = new Library();

        // Create instances of LendingService and InventoryManager
        LendBook lendBook = new LendBook(library);
        BookInventory bookInventory = new BookInventory();

        // Create a couple of books
        Book book1 = new Book("Book1", "Auhtor1", "1234", 1925);
        Book book2 = new Book("Book2", "Auhtor2", "5678", 1949);
        Book book3 = new Book("Book23", "Auhtor3", "91011", 1960);
        Book book4 = new Book("Book3", "Auhtor4", "91013", 1970);

        // Add books to the library inventory
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Create patrons
        Patron patron1 = new Patron("Subbu", "P001");
        Patron patron2 = new Patron("Kirtan", "P002");

        // Checkout a book
        System.out.println("Attempting to checkout 'Book1");
        lendBook.checkoutBook(patron1, "1234"); // Book ISBN
        System.out.println("Books borrowed by"+patron1.getPatronName()+" :" + patron1.getBorrowedBooks());

        // Search for books in the library
        System.out.println("\nSearching for books by 'Auhtor2'...");
        List<Book> searchResults = library.searchBooks("Auhtor2");
        System.out.println("Found books: " + searchResults);

        // Attempting to checkout a book that's already borrowed
        System.out.println("\nAttempting to checkout 'Book23");
        lendBook.checkoutBook(patron2, "91011"); // Book ISBN

        // Return a book
        System.out.println("\nReturning 'Book1");
        lendBook.returnBook(patron1, "1234");
        System.out.println("Books borrowed by :"+patron1.getPatronName()+" return: " + patron1.getBorrowedBooks());

        // Checkout a book again for Jane Smith
        System.out.println("\nAttempting to checkout 'Book23");
        lendBook.checkoutBook(patron2, "91011"); // Book ISBN
        System.out.println("Books borrowed by :"+patron2.getPatronName()+" return: " + patron2.getBorrowedBooks());
    }
}