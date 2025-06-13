package com.bootcamp.demo.demo_bc_calculator.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_bc_calculator.controller.CalculatorOperation;
import com.bootcamp.demo.demo_bc_calculator.dto.ReqDTO;
import com.bootcamp.demo.demo_bc_calculator.dto.RespDTO;
import com.bootcamp.demo.demo_bc_calculator.model.Operation;
import com.bootcamp.demo.demo_bc_calculator.service.CalculatorService;

@RestController
public class CalculatorController implements CalculatorOperation{
  @Autowired
  private CalculatorService calculatorService;


  @Override
  public RespDTO operate1(String x, String y, String operation) {
    return operate(x, y, operation);
  }

  @Override
  public RespDTO operate2(String x, String y, String operation) {
    return operate(x, y, operation);
  }

  @Override
  public RespDTO operate3(ReqDTO reqDTO) {
    System.out.println("hello");
    return operate(reqDTO.getX(), reqDTO.getY(), reqDTO.getOperation());
  }
  
  // 1. NumberFormatException (Type)
  // 2. null check
  // 3. Conversion (enum)
  // 4. Exception Handling

  // ! Happy Flow ONLY
  private RespDTO operate(String x, String y, String operation) {
    if (x == null || y == null || operation == null)
      throw new IllegalArgumentException("Invalid Operation.");
    double doubleX = Double.parseDouble(x);
    double doubleY = Double.parseDouble(y);
    Operation op = Operation.of(operation);
    double result = this.calculatorService.operate(doubleX, doubleY, op);
    return RespDTO.builder() //
      .x(x)
      .y(y)
      .operation(operation)
      .result(String.valueOf(result))
      .build();
  }
}
