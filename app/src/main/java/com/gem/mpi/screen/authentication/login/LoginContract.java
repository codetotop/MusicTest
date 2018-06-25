package com.gem.mpi.screen.authentication.login;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

import retrofit2.Callback;

/**
 * The Login Contract
 */
interface LoginContract {

  interface Interactor extends IInteractor<Presenter> {
    //void login(String username, String password, Callback<UserDTO> callback);

  }

  interface View extends PresentView<Presenter> {
  }

  interface Presenter extends IPresenter<View, Interactor> {
    void login(String username, String password);

  }
}



