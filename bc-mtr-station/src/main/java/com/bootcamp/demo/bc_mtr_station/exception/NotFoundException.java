package com.bootcamp.demo.bc_mtr_station.exception;

import com.bootcamp.demo.bc_mtr_station.model.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
  private String code;

  public static NotFoundException of(ErrorCode errorCode) {
    return new NotFoundException(errorCode);
  } 

  private NotFoundException(ErrorCode errorCode) { 
    super(errorCode.getErrMsg());
    this.code = errorCode.getErrCode();
  }
}
