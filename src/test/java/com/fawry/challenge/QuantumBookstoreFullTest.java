package com.fawry.challenge;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QuantumBookstoreFullTest extends TestCase {

  public QuantumBookstoreFullTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(QuantumBookstoreFullTest.class);
  }

  public void testBookstore() {
    assertTrue(true);
  }
}