package com.bootcamp.demo.bc_mtr_station.model;

// Java 1.5
public class ApiResp<T> {
  private String code; // "000000"
  private String message; // "success."
  private T data;

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  private ApiResp(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static class Builder<T> {
    private String code;
    private String message;
    private T data;

    public Builder() {
      this.code = "000000";
      this.message = "success.";
    }

    // public Builder<T> ok() {
    //   this.code = "000000";
    //   this.message = "sucess.";
    //   return this;
    // }

    // ! R48-R56 replaced by R36-39, using ENUM to Preventing others 
    // !   from causing trouble maliciously
    // public Builder<T> code(SysCode sysCode) {
    //   this.code = sysCode.getCode();
    //   return this;
    // }

    // public Builder<T> message(SysCode sysCode) {
    //   this.message = sysCode.getMessage();
    //   return this;
    // }

    public Builder<T> status(SysCode sysCode) {
      this.code = sysCode.getCode();
      this.message = sysCode.getMessage();
      return this;
    }

    public Builder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
      return new ApiResp<>(this);
    }
  }
}
