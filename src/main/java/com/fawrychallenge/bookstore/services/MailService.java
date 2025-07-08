
package com.fawrychallenge.bookstore.services;

import com.fawrychallenge.bookstore.books.core.Emailable;

public class MailService {

  public static void sendEmail(Emailable book, int quantity, String email) {
    String message = "Quantum book store: Sending " + quantity + "x '" + book.getTitle() + "' (" + book.getFileType()
        + ") by " + book.getAuthor() + " to email: " + email;
    System.out.println(message);
  }
}