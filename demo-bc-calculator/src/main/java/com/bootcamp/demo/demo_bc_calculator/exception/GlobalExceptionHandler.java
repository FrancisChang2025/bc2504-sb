package com.bootcamp.demo.demo_bc_calculator.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.demo_bc_calculator.dto.ErrorDTO;

//! Unhappy Flow
@RestControllerAdvice  // @ControllerAdvise + @ResponseBody
public class GlobalExceptionHandler {
  @ExceptionHandler(value = {NumberFormatException.class,
      NotFoundException.class, IllegalArgumentException.class})
  public ErrorDTO handleInvalidInput(RuntimeException ex) {
    return ErrorDTO.builder() //
        .code(9) //
        .message("Invalid Input: " + ex.getMessage()) //
        .build();
  }

  @ExceptionHandler(value = Exception.class)
  public ErrorDTO handleOtherException(RuntimeException ex) {
    return ErrorDTO.builder() //
        .code(99) //
        .message("Unhandled Exception.") //
        .build();
  }
}
