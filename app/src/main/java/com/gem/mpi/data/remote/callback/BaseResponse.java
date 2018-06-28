package com.gem.mpi.data.remote.callback;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by admin on 11/16/2017.
 * SimpleCommandResponse
 */

public class BaseResponse<T> implements Serializable {
  @SerializedName("errcode")
  Integer errcode;
  @SerializedName("message")
  String message;
  @SerializedName("data")
  private T data;

  public Integer getErrcode() {
    return errcode;
  }

  public void setErrcode(Integer errcode) {
    this.errcode = errcode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
