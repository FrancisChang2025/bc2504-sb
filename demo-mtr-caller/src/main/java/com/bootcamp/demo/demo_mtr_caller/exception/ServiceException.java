package com.bootcamp.demo.demo_mtr_caller.exception;

import com.bootcamp.demo.demo_mtr_caller.model.ErrorCode;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
  private String code;

  public static ServiceException of(ErrorCode errorCode, String message) {
    return new ServiceException(errorCode, message);
  }

  private ServiceException(ErrorCode errorCode, String message) {
    super(message);
    this.code = errorCode.getErrCode();
  }
}
