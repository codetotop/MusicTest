package com.gem.mpi.screen.authentication.login;

import com.gem.mpi.data.dto.LoginDTO;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The Login Contract
 */
interface LoginContract {

  interface Interactor extends IInteractor<Presenter> {
    void login(String username, String password, CommonCallback<LoginDTO> callback);

  }

  interface View extends PresentView<Presenter> {
    void showMessageSuccess();
    void showMessageError();
  }

  interface Presenter extends IPresenter<View, Interactor> {
    void login(String username, String password);
    void openScreenForgotPassWord();
  }
}



