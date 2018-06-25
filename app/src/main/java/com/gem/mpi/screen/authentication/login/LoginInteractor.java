package com.gem.mpi.screen.authentication.login;

import com.gem.mpi.data.dto.UserDTO;
import com.gemvietnam.base.viper.Interactor;
import com.gem.mpi.data.remote.ServiceBuilder;

import retrofit2.Callback;

/**
 * Created by BaVV on 20/11/2017.
 * LoginInteractor
 */

class LoginInteractor extends Interactor<LoginContract.Presenter> implements LoginContract.Interactor {
  LoginInteractor(LoginContract.Presenter presenter) {
    super(presenter);
  }

  @Override
  public void login(String username, String password, Callback<UserDTO> callback) {
    ServiceBuilder.getCommonService().login(username, password, "password", true).enqueue(callback);
  }
}
