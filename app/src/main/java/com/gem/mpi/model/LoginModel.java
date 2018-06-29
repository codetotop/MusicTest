package com.gem.mpi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoginModel implements Serializable {
  private List<FunctionModel> funcitonModels;
  private UserModel userModel;
  private String actionToken;

  public LoginModel() {
    funcitonModels = new ArrayList<>();
    userModel = new UserModel();
  }

  public List<FunctionModel> getFuncitonModels() {
    return funcitonModels;
  }

  public void setFuncitonModels(List<FunctionModel> funcitonModels) {
    this.funcitonModels = funcitonModels;
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
        "funcitonModels=" + funcitonModels.get(0) +
        ", userModel=" + userModel +
        ", actionToken='" + actionToken + '\'' +
        '}';
  }
}
