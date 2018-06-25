package com.gem.mpi.screen.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.gem.mpi.R;
import com.gem.mpi.model.LocationModel;
import com.gemvietnam.base.viper.ViewFragment;

/**
 * The Home Fragment
 */
public class HomeFragment extends ViewFragment<HomeContract.Presenter> implements HomeContract.View {

  public static HomeFragment getInstance(Bundle data) {
    HomeFragment fragment = new HomeFragment();
    fragment.setArguments(data);
    return fragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_home;
  }

  @Override
  public void updateLocationView(@NonNull LocationModel locationDTO) {
  }

  @Override
  public void onStart() {
    super.onStart();
  }

  @Override
  public void onStop() {
    super.onStop();
  }
}
