package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.FunctionDTO;
import com.gem.mpi.data.dto.LoginDTO;
import com.gem.mpi.model.LoginModel;

public class LoginMapper {

    public static LoginModel transform(LoginDTO loginDTO) {
        if (loginDTO != null) {
            LoginModel loginModel = new LoginModel();
            for (FunctionDTO functionDTO : loginDTO.getFunctionDTOS()) {
                if (functionDTO != null)
                    loginModel.getFunctionModels().add(FunctionMapper.transform(functionDTO));
            }
            loginModel.setActionToken(loginDTO.getAccessToken());
            loginModel.setUserModel(UserMapper.transform(loginDTO.getUserDTO()));

            return loginModel;
        }

        return null;
    }
}
