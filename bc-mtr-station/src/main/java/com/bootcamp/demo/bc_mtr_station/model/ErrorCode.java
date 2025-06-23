package com.bootcamp.demo.bc_mtr_station.model;

import lombok.Getter;

@Getter
public enum ErrorCode {
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
