package com.bootcamp.demo.demo_sb_restful;

public class Worker {
  
  private Tool tool;

  public Worker(Tool tool) {
    if (tool == null)
      throw new RuntimeException();
    this.tool = tool;
  }

  public void work() {
    this.tool.sleep();
  }

  public static void main(String[] args) {
    try {
      Worker worker1 = new Worker(null); // exception
      worker1.work(); 
    } catch (RuntimeException e) {
      Worker worker1 = new Worker(new Tool());
    }
    
  }
}
