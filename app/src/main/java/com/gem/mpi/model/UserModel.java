package com.gem.mpi.model;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String userName;
    private int userID;
    private String userDepartment;
    private String userPosition;
    private String userDob;
    private String userEmail;
    private String userDepartmentPhone;
    private String userCellPhone;
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

    @Override
    public String toString() {
        return "UserModel{" +
            "userName='" + userName + '\'' +
            ", userID=" + userID +
            ", userDepartment='" + userDepartment + '\'' +
            ", userPosition='" + userPosition + '\'' +
            ", userDob='" + userDob + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", userDepartmentPhone='" + userDepartmentPhone + '\'' +
            ", userCellPhone='" + userCellPhone + '\'' +
            ", userAvatar='" + userAvatar + '\'' +
            '}';
    }
}
