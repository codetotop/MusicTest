package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class LoginDTO implements Serializable{
    @SerializedName("access_functions")
    @Expose
    private List<FunctionDTO> functionDTOS;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("user")
    @Expose
    private UserDTO userDTO;

    public List<FunctionDTO> getFunctionDTOS() {
        return functionDTOS;
    }

    public void setFunctionDTOS(List<FunctionDTO> functionDTOS) {
        this.functionDTOS = functionDTOS;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
