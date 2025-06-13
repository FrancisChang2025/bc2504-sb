package com.bootcamp.demo.demo_bc_calculator.model;

import com.bootcamp.demo.demo_bc_calculator.exception.NotFoundException;

public enum Operation {
  ADD, SUB, MUL, DIV,;

  public static Operation of(String operation) {
    for (Operation op : Operation.values()) {
      if (op.name().equalsIgnoreCase(operation))
        return op;
    }
    throw new NotFoundException("Operation is invalid.");
  }
}
