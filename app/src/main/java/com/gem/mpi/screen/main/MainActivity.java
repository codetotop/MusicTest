package com.gem.mpi.screen.main;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gem.mpi.screen.base.AppBaseActivity;
import com.gem.mpi.screen.main.main.MainPresenter;
import com.gem.mpi.screen.main.profiledetail.ProfileDetailPresenter;
import com.gemvietnam.base.viper.ViewFragment;

public class MainActivity extends AppBaseActivity {
  @Override
  public ViewFragment onCreateFirstFragment() {
    return (ViewFragment) new MainPresenter(this).getFragment();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public int getLayoutId() {
    return R.layout.activity_main;
  }
}
