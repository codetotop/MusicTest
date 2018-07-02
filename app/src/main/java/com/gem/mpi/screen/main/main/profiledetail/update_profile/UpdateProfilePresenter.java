package com.gem.mpi.screen.main.main.profiledetail.update_profile;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The UpdateProfile Presenter
 */
public class UpdateProfilePresenter extends Presenter<UpdateProfileContract.View, UpdateProfileContract.Interactor> implements UpdateProfileContract.Presenter {

  public UpdateProfilePresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {

  }

  @Override
  public UpdateProfileContract.Interactor onCreateInteractor() {
    return new UpdateProfileInteractor(this);
  }

  @Override
  public UpdateProfileContract.View onCreateView(Bundle data) {
    return UpdateProfileFragment.getInstance(data);
  }

  @Override
  public void handleActionLeft() {
    getView().getFragmentManager().popBackStack();
  }
}
