package com.gem.mpi.model;

import java.io.Serializable;
import java.util.List;

public class LoginModel implements Serializable {
    private List<FunctionModel> funcitonModels;
    private UserModel userModel;
    private String actionToken;

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
}
