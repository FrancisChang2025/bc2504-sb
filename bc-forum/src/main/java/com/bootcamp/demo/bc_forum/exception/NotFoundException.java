package com.bootcamp.demo.bc_forum.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
  private long errCode;

  public NotFoundException(SysError sysError) {   // constructor
    super(sysError.getErrMsg());
    this.errCode = sysError.getErrCode();
  }
}
