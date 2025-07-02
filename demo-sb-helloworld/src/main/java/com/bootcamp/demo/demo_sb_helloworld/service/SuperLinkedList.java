package com.bootcamp.demo.demo_sb_helloworld.service;

import com.bootcamp.demo.demo_sb_helloworld.model.Dog;

// LinkedList -> Node -> Dog
public class SuperLinkedList<T> {
  private int size; // bmi
  private SuperNode<T> firstNode; // height
  private SuperNode<T> lastNode; // weight

  public SuperLinkedList() {

  }

  public int size() {
    return this.size;
  }
  
  public boolean add(T data){ 
    this.size++;
    if ( (this.lastNode == null)) {
      this.lastNode = new SuperNode<>(data);
      return true;
    }
    lastNode.setNext(new SuperNode<>(data));
    return true;
  }

  private static class SuperNode<T> {
    private T data;
    private SuperNode<T> next;

    public SuperNode(T data) {
      this.data = data;
    }

    public void setNext(SuperNode<T> node) {
      this.next = node;
    }
  }

  public static void main(String[] args) {
    SuperLinkedList<Dog> dogs = new SuperLinkedList<>();
    dogs.add(new Dog(13));
    dogs.add(new Dog(3));
    dogs.add(new Dog(7));
    System.out.println(dogs.size());
  }
}
