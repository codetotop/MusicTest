package com.gem.mpi.screen.authentication.login;

import com.gemvietnam.base.viper.Interactor;

/**
 * The Login interactor
 */
class LoginInteractor extends Interactor<LoginContract.Presenter>
    implements LoginContract.Interactor {

  LoginInteractor(LoginContract.Presenter presenter) {
    super(presenter);
  }
}
