package com.bootcamp.demo.demo_mtr_caller.model;

public class Tutor {
  private String firstName;
  private String lastName;

  public void setFullName(String fullName) { // Vincent Lau
    String[] names = fullName.split(" ", 2);
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
