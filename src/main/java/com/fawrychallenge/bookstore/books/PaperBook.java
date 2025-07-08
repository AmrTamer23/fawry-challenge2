
package com.fawrychallenge.bookstore.books;

import com.fawrychallenge.bookstore.books.core.Book;
import com.fawrychallenge.bookstore.books.core.Shippable;

public class PaperBook extends Book implements Shippable {
  private double weight;

  public PaperBook(String isbn, String title, String author, int yearPublished, double price, int quantity,
      double weight) {
    super(isbn, title, author, yearPublished, price, quantity);
    this.weight = weight;
  }

  @Override
  public double getWeight() {
    return weight;
  }
}