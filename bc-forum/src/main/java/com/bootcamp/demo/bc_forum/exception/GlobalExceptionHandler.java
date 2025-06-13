package com.bootcamp.demo.bc_forum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.bootcamp.demo.bc_forum.dto.ErrorDTO;

// ! Task 3C
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
  @ExceptionHandler(value = NumberFormatException.class)
  public ErrorDTO handleNumberFormatException() {
    return ErrorDTO.builder() //
        .code(2L) //
        .message("Invalid Input.") //
        .build();
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
  @ExceptionHandler(value = NotFoundException.class)
  public ErrorDTO handleNotFoundException(NotFoundException ex) {
    return ErrorDTO.builder() //
        .code(ex.getErrCode()) //
        .message(ex.getMessage()) //
        .build();
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400
  @ExceptionHandler(value = RestClientException.class)
  public ErrorDTO handleRestClientException(RestClientException ex) {
    return ErrorDTO.builder() //
        .code(3L) //
        .message("RestTemplate Error: JsonPlacHolder.") //
        .build();
  }
}
