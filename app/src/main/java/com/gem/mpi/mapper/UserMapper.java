package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.UserDTO;
import com.gem.mpi.model.UserModel;

public class UserMapper {
    public static UserModel transform(UserDTO userDTO){
        if(userDTO!=null){
            UserModel userModel = new UserModel();
            userModel.setUserName(userDTO.getUserName());
            userModel.setUserID(userDTO.getUserID());
            userModel.setUserDepartment(userDTO.getUserDepartment());
            userModel.setUserPosition(userDTO.getUserPosition());
            userModel.setUserDob(userDTO.getUserDob());
            userModel.setUserEmail(userDTO.getUserEmail());
            userModel.setUserDepartmentPhone(userDTO.getUserDepartmentPhone());
            userModel.setUserCellPhone(userDTO.getUserCellPhone());
            userModel.setUserAvatar(userDTO.getUserAvatar());

            return userModel;
        }

        return null;
    }

    public static UserDTO transform(UserModel userModel){
        if(userModel!=null){
            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(userModel.getUserName());
            userDTO.setUserID(userModel.getUserID());
            userDTO.setUserDepartment(userModel.getUserDepartment());
            userDTO.setUserPosition(userModel.getUserPosition());
            userDTO.setUserDob(userModel.getUserDob());
            userDTO.setUserEmail(userModel.getUserEmail());
            userDTO.setUserDepartmentPhone(userModel.getUserDepartmentPhone());
            userDTO.setUserCellPhone(userModel.getUserCellPhone());
            userDTO.setUserAvatar(userModel.getUserAvatar());

            return userDTO;
        }

        return null;
    }
}
