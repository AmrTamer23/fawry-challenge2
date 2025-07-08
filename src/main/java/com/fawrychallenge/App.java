package com.fawrychallenge;

import java.util.List;

import com.fawrychallenge.bookstore.books.EBook;
import com.fawrychallenge.bookstore.books.PaperBook;
import com.fawrychallenge.bookstore.books.ShowcaseBook;
import com.fawrychallenge.bookstore.books.core.Book;
import com.fawrychallenge.bookstore.inventory.BookInventory;

public class App {
  public static void main(String[] args) throws Exception {
    BookInventory inventory = new BookInventory();

    PaperBook effectiveJava = new PaperBook("978-0134685991", "Effective Java", "Joshua Bloch", 2017, 45.99, 10, 0.8);
    EBook cleanCode = new EBook("978-0135957059", "Clean Code", "Robert Martin", 2008, 35.99, 50, "PDF");
    ShowcaseBook concurrency = new ShowcaseBook("978-0321349606", "Java Concurrency in Practice", "Brian Goetz", 2006);
    PaperBook designPatterns = new PaperBook("978-0596007737", "Head First Design Patterns", "Eric Freeman", 2004,
        39.99, 5, 1.2);
    EBook javaReference = new EBook("978-0134685997", "Java: The Complete Reference", "Herbert Schildt", 1996, 29.99,
        100, "EPUB");

    inventory.addBook(effectiveJava);
    inventory.addBook(cleanCode);
    inventory.addBook(concurrency);
    inventory.addBook(designPatterns);
    inventory.addBook(javaReference);

    inventory.displayInventory();

    try {
      double cost1 = inventory.buyBook("978-0134685991", 2, "customer@example.com", "123 Main St, City, Country");
      System.out.println("Quantum book store: Payment processed: $" + cost1);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      double cost2 = inventory.buyBook("978-0135957059", 1, "reader@example.com", "456 Oak Ave, Town, Country");
      System.out.println("Quantum book store: Payment processed: $" + cost2);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      inventory.buyBook("978-0321349606", 1, "test@example.com", "789 Pine St, Village, Country");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    List<Book> removedBooks = inventory.removeOutdatedBooks(15);
    for (Book book : removedBooks) {
      System.out.println("Quantum book store: Removed outdated book: " + book.getTitle() + " by " + book.getAuthor()
          + " (Published: " + book.getYearPublished() + ")");
    }

    inventory.displayInventory();
  }
}