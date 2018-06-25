package com.gem.mpi.screen.authentication;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gem.mpi.screen.authentication.login.LoginPresenter;
import com.gem.mpi.screen.base.AppBaseActivity;
import com.gemvietnam.base.viper.ViewFragment;

public class AuthencationActivity extends AppBaseActivity {

  @Override
  public ViewFragment onCreateFirstFragment() {
    return (ViewFragment) new LoginPresenter(this).getFragment();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public int getLayoutId() {
    return R.layout.activity_authencation;
  }
}
