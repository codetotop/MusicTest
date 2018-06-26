package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserDTO implements Serializable {
    @SerializedName("user_name")
    @Expose
    private String userName;

    @SerializedName("user_id")
    @Expose
    private int userID;

    @SerializedName("user_department")
    @Expose
    private String userDepartment;

    @SerializedName("user_position")
    @Expose
    private String userPosition;

    @SerializedName("user_dob")
    @Expose
    private String userDob;

    @SerializedName("user_email")
    @Expose
    private String userEmail;

    @SerializedName("user_department_phone")
    @Expose
    private String userDepartmentPhone;

    @SerializedName("user_cell_phone")
    @Expose
    private String userCellPhone;

    @SerializedName("user_avatar")
    @Expose
    private String userAvatar;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserDepartmentPhone() {
        return userDepartmentPhone;
    }

    public void setUserDepartmentPhone(String userDepartmentPhone) {
        this.userDepartmentPhone = userDepartmentPhone;
    }

    public String getUserCellPhone() {
        return userCellPhone;
    }

    public void setUserCellPhone(String userCellPhone) {
        this.userCellPhone = userCellPhone;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
}
