package com.gem.mpi.screen.main.main.registration_business;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;

/**
 * The RegistrationBusiness Fragment
 */
public class RegistrationBusinessFragment extends ViewFragment<RegistrationBusinessContract.Presenter> implements RegistrationBusinessContract.View {
  @BindView(R.id.fragmentregistrationbusiness_rv_list_registration_business)
  RecyclerView mListRegistrationBusinessRv;

  public static RegistrationBusinessFragment getInstance() {
    return new RegistrationBusinessFragment();
  }

  public static RegistrationBusinessFragment getInstance(Bundle data) {
    RegistrationBusinessFragment registrationBusinessFragment = new RegistrationBusinessFragment();
    registrationBusinessFragment.setArguments(data);
    return registrationBusinessFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_registration_business;
  }

  @Override
  public void initListRegistrationBusiness() {
    mListRegistrationBusinessRv.setLayoutManager(new LinearLayoutManager(getViewContext()));
    mListRegistrationBusinessRv.setAdapter(getPresenter().getRegistrationBusinessAdapter());
  }
}
