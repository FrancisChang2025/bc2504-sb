package com.bootcamp.demo.demo_mtr_caller.model;

import lombok.Getter;

@Getter
public enum ErrorCode {  
  MTR_SERVICE_EXCEPTION("999997", "MTR Service Exception."), //
  STATION_CODE_NOT_FOUND("999998", "Station code not found."), //
  UNHANLED_EXCEPTION("999999", "Unhandled Exception.") //
  ;
  
  private final String errCode;
  private final String errMsg;

  private ErrorCode(String errCode, String errMsg) {
    this.errCode = errCode;
    this.errMsg = errMsg;
  }
}
