package com.gem.mpi.screen.main.main.registration_business;

import android.os.Bundle;
import android.os.Handler;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The RegistrationBusiness Presenter
 */
public class RegistrationBusinessPresenter extends Presenter<RegistrationBusinessContract.View, RegistrationBusinessContract.Interactor> implements RegistrationBusinessContract.Presenter {
  private RegistrationBusinessAdapter mRegistrationBusinessAdapter;

  public RegistrationBusinessPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    mRegistrationBusinessAdapter = new RegistrationBusinessAdapter(null);
    getView().showProgress();
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        getView().initListRegistrationBusiness();
        getView().hideProgress();
      }
    }, 300);
  }

  @Override
  public RegistrationBusinessContract.Interactor onCreateInteractor() {
    return new RegistrationBusinessInteractor(this);
  }

  @Override
  public RegistrationBusinessContract.View onCreateView(Bundle data) {
    return RegistrationBusinessFragment.getInstance(data);
  }

  @Override
  public RegistrationBusinessAdapter getRegistrationBusinessAdapter() {
    return mRegistrationBusinessAdapter;
  }
}
