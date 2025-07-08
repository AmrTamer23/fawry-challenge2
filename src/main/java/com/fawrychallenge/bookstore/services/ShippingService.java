
package com.fawrychallenge.bookstore.services;

import com.fawrychallenge.bookstore.books.core.Shippable;

public class ShippingService {

  public static void ship(Shippable book, int quantity, String address) {
    System.out.println("Quantum book store: Shipping " + quantity + "x '" + book.getTitle() + "' by " + book.getAuthor()
        + " to address: " + address);
    System.out.println("Quantum book store: Total weight: " + (book.getWeight() * quantity) + "g");
  }
}