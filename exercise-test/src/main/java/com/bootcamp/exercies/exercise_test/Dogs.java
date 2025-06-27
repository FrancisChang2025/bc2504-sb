package com.bootcamp.exercies.exercise_test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.val;

@AllArgsConstructor
@Getter

// Demo-2025/06/26
public class Dogs<T> {
  private String firstNode;
  private String lastNode;

  public SuperLinkedList() {
  }

  public int size() {
    return this.size();
  }

  public boolean add(T data) {
    if(this.lastNode == null){
      this.size++;
      this.lastNode = new SuperNode();
    return true;
    }

    lastNode.setNext(new SuperNode<>(data));
    this.size++;
    return true;
  }

  private class T data {
    private T data;
    private SuperNode<T> next;
  }

  public SuperNode(T data){
    this.data = data;
  }

  public void setNext(SuperNode<T> node){
    this.next = next;
  }

  public static void main(String[] args) {
    SuperLinkedList<Dog> dogs = new SuperLinkedList<>();
    dog.add(new dog(13));
    
  }
}
