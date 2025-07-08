package com.fawrychallenge.bookstore.books.core;

import java.time.LocalDate;

public abstract class Book {
  protected String isbn;
  protected String title;
  protected String author;
  protected int yearPublished;
  protected double price;
  protected int quantity;

  public Book(String isbn, String title, String author, int yearPublished, double price, int quantity) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.yearPublished = yearPublished;
    this.price = price;
    this.quantity = quantity;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getYearPublished() {
    return yearPublished;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void reduceQuantity(int amount) throws Exception {
    if (amount > quantity) {
      String errorMessage = "Quantum book store: Error: Cannot reduce quantity by " + amount + " for book '" + title
          + "'. Current stock: " + quantity + ", requested: " + amount;
      throw new Exception(errorMessage);
    }
    quantity -= amount;
  }

  public boolean isOutdated(int yearsThreshold) {
    int currentYear = LocalDate.now().getYear();
    return (currentYear - yearPublished) > yearsThreshold;
  }

  public boolean isForSale() {
    return true;
  }
}