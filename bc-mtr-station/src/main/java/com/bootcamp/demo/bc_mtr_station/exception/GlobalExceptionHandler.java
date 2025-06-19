package com.bootcamp.demo.bc_mtr_station.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.bc_mtr_station.exception.dto.ErrorDTO;
import com.bootcamp.demo.bc_mtr_station.model.ApiResp;
import com.bootcamp.demo.bc_mtr_station.model.SysCode;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = RuntimeException.class)
  public ApiResp<ErrorDTO> handleRuntimeException(RuntimeException ex) {
    ErrorDTO errorDTO = ErrorDTO.builder() //
        .code("000001") //
        .message(ex.getMessage()) //
        .build();
    return ApiResp.<ErrorDTO>builder()
      .status(SysCode.OK)
      .data(errorDTO)
      .build();
  }
}
