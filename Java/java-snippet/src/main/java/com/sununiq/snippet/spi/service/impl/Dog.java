package com.sununiq.snippet.spi.service.impl;

import com.sununiq.snippet.spi.service.Animal;

/**
 *
 **/
public class Dog implements Animal {
  @Override
  public void eat() {
    System.out.println("Dog eating...");
  }
}
