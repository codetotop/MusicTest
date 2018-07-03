package com.gem.mpi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoginModel implements Serializable {
  private List<FunctionModel> functionModels;
  private UserModel userModel;
  private String actionToken;

  public LoginModel() {
    functionModels = new ArrayList<>();
    userModel = new UserModel();
  }

  public List<FunctionModel> getFunctionModels() {
    return functionModels;
  }

  public void setFunctionModels(List<FunctionModel> functionModels) {
    this.functionModels = functionModels;
  }

  public UserModel getUserModel() {
    return userModel;
  }

  public void setUserModel(UserModel userModel) {
    this.userModel = userModel;
  }

  public String getActionToken() {
    return actionToken;
  }

  public void setActionToken(String actionToken) {
    this.actionToken = actionToken;
  }

  @Override
  public String toString() {
    return "LoginModel{" +
        "functionModels=" + functionModels.get(0) +
        ", userModel=" + userModel +
        ", actionToken='" + actionToken + '\'' +
        '}';
  }
}
