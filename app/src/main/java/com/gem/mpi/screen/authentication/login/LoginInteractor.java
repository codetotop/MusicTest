package com.gem.mpi.screen.authentication.login;

import com.gem.mpi.data.dto.LoginDTO;
import com.gem.mpi.data.remote.ServiceBuilder;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.data.remote.request.LoginRequest;
import com.gemvietnam.base.viper.Interactor;

import retrofit2.Callback;

/**
 * The Login interactor
 */
class LoginInteractor extends Interactor<LoginContract.Presenter>
    implements LoginContract.Interactor {

  LoginInteractor(LoginContract.Presenter presenter) {
    super(presenter);
  }


  @Override
  public void login(String username, String password, CommonCallback<LoginDTO> callback) {
    LoginRequest loginRequest = new LoginRequest();
    loginRequest.setUserName(username);
    loginRequest.setPassWord(password);

  }
}
