package com.bootcamp.demo.demo_sb_helloworld.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cat {
  private String name;
  private int age; // 1) save java file, 2) javac -> class file, 3) java -> execute class file

  public static void sleep() {

  }

  public static void main(String[] args) {
    int[] arr = new int[] {3, 7, 1, 6};
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));

    // ! Overuse?

    // HashSet: Hash (No ordering), avoid duplicate
    // ArrayList -> ordering, allow duplicate (add/ remove/ size)
    // LinkedList -> ordering, allow duplicate (size)
    // Stack -> last in first out (thread safe), allow duplicate
    // Vector -> thread safe arraylist, allow duplicate
    // HashMap -> Entry<key, value>   // ! Hash (No-ordering), no duplicate (by key)

    // ! how to implement an non-thread safe stack? Tips: existing data structure
    // List<Integer> integers = List.of(3, 7, 1, 6); // List.of not allow add/remove/set
    // Map<Integer, Integer> integers = new HashMap<>();
    List<Integer> integers = new ArrayList<>(Arrays.asList(3, 7, 1, 6));
    Collections.sort(integers);
    System.out.println(integers);
    // integers.add(10);

    // Class and Object (Object.class -> Polymorphism & instanceOf, equals() and hashCode())
    // APIE -> Polymorphism (Compile time, Run time)
    // Encapsulation -> getter, setter
    // Inherit -> abstract class vs class
    // Abstraction -> Java 8, FunctionalInterface, Lambda Expression

    // Data structure (Interface + Generic)
    // Exception (Unchecked exception, checked exception)
    // Serialization: Class vs JSON -> ObjectMapper
    // Wrapper Class vs Primitive
    // loop (for loop: difference?)
    // if, switch
  }
}
