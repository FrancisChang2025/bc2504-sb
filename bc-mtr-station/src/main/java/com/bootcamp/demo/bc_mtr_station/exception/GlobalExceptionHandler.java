package com.bootcamp.demo.bc_mtr_station.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.bc_mtr_station.exception.dto.ErrorDTO;
import com.bootcamp.demo.bc_mtr_station.model.ApiResp;
import com.bootcamp.demo.bc_mtr_station.model.ErrorCode;
import com.bootcamp.demo.bc_mtr_station.model.SysCode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(value = HttpStatus.OK)  // JSON consistancy
  @ExceptionHandler(value = NotFoundException.class)
  public ApiResp<ErrorDTO> handleNotFoundException(NotFoundException ex) {
    ErrorDTO errorDTO = ErrorDTO.builder() //
        .code(ex.getCode())
        .message(ex.getMessage()) //
        .build();
    return ApiResp.<ErrorDTO>builder()
      .status(SysCode.FAIL) // 999999
      .data(errorDTO)
      .build();
  }

  @ResponseStatus(value = HttpStatus.OK)  // JSON consistancy
  @ExceptionHandler(value = RuntimeException.class)
  public ApiResp<ErrorDTO> handleRuntimeException(RuntimeException ex) {
    ErrorDTO errorDTO = ErrorDTO.builder() //
        .code(ErrorCode.UNHANLED_EXCEPTION.getErrCode()) 
        .message(ErrorCode.UNHANLED_EXCEPTION.getErrMsg() + "-" + ex.getMessage()) //
        .build();
    return ApiResp.<ErrorDTO>builder()
      .status(SysCode.FAIL) // "999999"
      .data(errorDTO)
      .build();
  }
}
