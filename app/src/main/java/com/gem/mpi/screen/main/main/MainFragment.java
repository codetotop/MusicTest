package com.gem.mpi.screen.main.main;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

/**
 * The Main Fragment
 */
public class MainFragment extends ViewFragment<MainContract.Presenter> implements MainContract.View {

  public static MainFragment getInstance() {
    return new MainFragment();
  }

  public static MainFragment getInstance(Bundle data) {
    MainFragment mainFragment = new MainFragment();
    mainFragment.setArguments(data);
    return mainFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_main;
  }
}
