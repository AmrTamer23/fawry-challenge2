
package com.fawrychallenge.bookstore.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fawrychallenge.bookstore.books.EBook;
import com.fawrychallenge.bookstore.books.PaperBook;
import com.fawrychallenge.bookstore.books.core.Book;
import com.fawrychallenge.bookstore.books.core.Emailable;
import com.fawrychallenge.bookstore.books.core.Shippable;
import com.fawrychallenge.bookstore.services.MailService;
import com.fawrychallenge.bookstore.services.ShippingService;

public class BookInventory {
  private Map<String, Book> books;

  public BookInventory() {
    this.books = new HashMap<>();
  }

  public void addBook(Book book) {
    books.put(book.getIsbn(), book);
    System.out
        .println("Quantum book store: Added book '" + book.getTitle() + "' by " + book.getAuthor() + " to inventory");
  }

  public List<Book> removeOutdatedBooks(int yearsThreshold) {
    List<Book> removedBooks = new ArrayList<>();
    List<String> toRemove = new ArrayList<>();

    for (Book book : books.values()) {
      if (book.isOutdated(yearsThreshold)) {
        removedBooks.add(book);
        toRemove.add(book.getIsbn());
      }
    }

    for (String isbn : toRemove) {
      books.remove(isbn);
    }

    System.out.println("Quantum book store: Removed " + removedBooks.size() + " outdated books (older than "
        + yearsThreshold + " years)");
    return removedBooks;
  }

  public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
    Book book = books.get(isbn);

    if (book == null) {
      throw new Exception("Quantum book store: Error: Book with ISBN '" + isbn + "' not found in inventory");
    }

    if (!book.isForSale()) {
      throw new Exception("Quantum book store: Error: Book '" + book.getTitle() + "' is not for sale");
    }

    book.reduceQuantity(quantity);
    double totalCost = book.getPrice() * quantity;

    System.out
        .println("Quantum book store: Purchased " + quantity + "x '" + book.getTitle() + "' by " + book.getAuthor());
    System.out.println("Quantum book store: Total amount: $" + totalCost);

    if (book instanceof PaperBook) {
      ShippingService.ship((Shippable) book, quantity, address);
    } else if (book instanceof EBook) {
      MailService.sendEmail((Emailable) book, quantity, email);
    }

    return totalCost;
  }

  public Book getBook(String isbn) {
    return books.get(isbn);
  }

  public void displayInventory() {
    System.out.println("Quantum book store: Current inventory:");
    for (Book book : books.values()) {
      String type = book instanceof PaperBook ? "Paper Book" : book instanceof EBook ? "E-Book" : "Showcase Book";
      System.out.println("- " + type + ": " + book.getTitle() + " by " + book.getAuthor() +
          " (ISBN: " + book.getIsbn() + ", Stock: " + book.getQuantity() +
          ", Price: $" + book.getPrice() + ")");
    }
  }
}