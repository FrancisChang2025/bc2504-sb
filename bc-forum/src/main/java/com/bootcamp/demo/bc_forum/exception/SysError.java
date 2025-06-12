package com.bootcamp.demo.bc_forum.exception;

import lombok.Getter;

@Getter
public enum SysError {
  USER_NOT_FOUND(1L, "User not found."),;

  private final long errCode;
  private final String errMsg;

  private SysError(long errCode, String errMsg) {
    this.errCode = errCode;
    this.errMsg = errMsg;
  }
}
