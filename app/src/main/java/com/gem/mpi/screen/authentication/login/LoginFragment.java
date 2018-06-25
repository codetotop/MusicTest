package com.gem.mpi.screen.authentication.login;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

/**
 * The Login Fragment
 */
public class LoginFragment extends ViewFragment<LoginContract.Presenter> implements LoginContract.View {

  public static LoginFragment getInstance() {
    return new LoginFragment();
  }

  public static LoginFragment getInstance(Bundle data) {
    LoginFragment loginFragment = new LoginFragment();
    loginFragment.setArguments(data);
    return loginFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_login;
  }
}
