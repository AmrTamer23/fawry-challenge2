
package com.fawrychallenge.bookstore.books;

import com.fawrychallenge.bookstore.books.core.Book;
import com.fawrychallenge.bookstore.books.core.Emailable;

public class EBook extends Book implements Emailable {
  private String fileType;

  public EBook(String isbn, String title, String author, int yearPublished, double price, int quantity,
      String fileType) {
    super(isbn, title, author, yearPublished, price, quantity);
    this.fileType = fileType;
  }

  @Override
  public String getFileType() {
    return fileType;
  }
}