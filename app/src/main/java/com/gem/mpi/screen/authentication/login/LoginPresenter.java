package com.gem.mpi.screen.authentication.login;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The Login Presenter
 */
public class LoginPresenter extends Presenter<LoginContract.View, LoginContract.Interactor>
    implements LoginContract.Presenter {

  public LoginPresenter(ContainerView containerView) {
    super(containerView);
  }


  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public LoginContract.Interactor onCreateInteractor() {
    return new LoginInteractor(this);
  }

  @Override
  public LoginContract.View onCreateView(Bundle data) {
    return LoginFragment.getInstance(data);
  }
}
