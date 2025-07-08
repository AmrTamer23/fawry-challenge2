package com.fawrychallenge.bookstore.books;

import com.fawrychallenge.bookstore.books.core.Book;

public class ShowcaseBook extends Book {

  public ShowcaseBook(String isbn, String title, String author, int yearPublished) {
    super(isbn, title, author, yearPublished, 0.0, 0);
  }

  @Override
  public boolean isForSale() {
    return false;
  }

  @Override
  public void reduceQuantity(int amount) throws Exception {
    throw new Exception(
        "Quantum book store: Error: Showcase book '" + title + "' is not for sale and cannot be purchased");
  }
}