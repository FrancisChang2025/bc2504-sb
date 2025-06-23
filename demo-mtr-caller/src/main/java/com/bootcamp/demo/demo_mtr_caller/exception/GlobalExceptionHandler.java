package com.bootcamp.demo.demo_mtr_caller.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.demo_mtr_caller.model.ApiResp;
import com.bootcamp.demo.demo_mtr_caller.model.SysCode;
import com.bootcamp.demo.demo_mtr_caller.model.dto.ErrorDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = ServiceException.class)
  public ApiResp<ErrorDTO> handleServiceException(ServiceException ex) {
    ErrorDTO errorDTO = ErrorDTO.builder() //
      .code(ex.getCode()) //
      .message(ex.getMessage()) //
      .build();
    return ApiResp.<ErrorDTO>builder() //
      .status(SysCode.FAIL) //
      .data(errorDTO) //
      .build();
  }
}
