package com.bootcamp.demo.demo_bc_calculator.service;

import com.bootcamp.demo.demo_bc_calculator.model.Operation;

public interface CalculatorService {
 
  double operate(double x, double y, Operation operation);

  // double add(double x, double y);

  // double subtract(double x, double y);

  // double multiply(double x, double y);

  // double divide(double x, double y);
}
