package com.gem.mpi.screen.authentication;

import com.gem.mpi.screen.authentication.login.LoginPresenter;
import com.gemvietnam.base.viper.ViewFragment;
import com.gem.mpi.screen.base.AppBaseActivity;

public class AuthenticationActivity extends AppBaseActivity {

  @Override
  public ViewFragment onCreateFirstFragment() {
    return (ViewFragment) new LoginPresenter(this).getFragment();
  }
}
