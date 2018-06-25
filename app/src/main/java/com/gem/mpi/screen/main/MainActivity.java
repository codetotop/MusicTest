package com.gem.mpi.screen.main;

import android.os.Bundle;

import com.gem.mpi.screen.main.home.HomePresenter;
import com.gemvietnam.base.viper.ViewFragment;
import com.gem.mpi.screen.base.AppBaseActivity;

public class MainActivity extends AppBaseActivity {
  @Override
  public ViewFragment onCreateFirstFragment() {
    return (ViewFragment) new HomePresenter(this).getFragment();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
