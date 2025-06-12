package com.bootcamp.demo.bc_forum.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.bootcamp.demo.bc_forum.dto.ErrorDTO;

// ! Task 3C
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = NumberFormatException.class)
  public ErrorDTO handleNumberFormatException() {
    return ErrorDTO.builder() //
        .code(2L) //
        .message("Invalid Input.") //
        .build();
  }

  @ExceptionHandler(value = NotFoundException.class)
  public ErrorDTO handleNotFoundException(NotFoundException ex) {
    return ErrorDTO.builder() //
        .code(ex.getErrCode()) //
        .message(ex.getMessage()) //
        .build();
  }

  @ExceptionHandler(value = RestClientException.class)
  public ErrorDTO handleRestClientException(RestClientException ex) {
    return ErrorDTO.builder() //
        .code(3L) //
        .message("RestTemplate Error: JsonPlacHolder.") //
        .build();
  }
}
