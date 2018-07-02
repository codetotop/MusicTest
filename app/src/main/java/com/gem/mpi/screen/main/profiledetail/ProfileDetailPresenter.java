package com.gem.mpi.screen.main.profiledetail;

import android.os.Bundle;

import com.gem.mpi.screen.main.profiledetail.update_profile.UpdateProfilePresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The ProfileDetail Presenter
 */
public class ProfileDetailPresenter extends Presenter<ProfileDetailContract.View, ProfileDetailContract.Interactor> implements ProfileDetailContract.Presenter {

  public ProfileDetailPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {

  }

  @Override
  public ProfileDetailContract.Interactor onCreateInteractor() {
    return new ProfileDetailInteractor(this);
  }

  @Override
  public ProfileDetailContract.View onCreateView(Bundle data) {
    return ProfileDetailFragment.getInstance(data);
  }

  @Override
  public void handleActionLeft() {
    getView().getFragmentManager().popBackStack();
  }

  @Override
  public void handleActionRight() {
    UpdateProfilePresenter updateProfilePresenter = new UpdateProfilePresenter(mContainerView);
    updateProfilePresenter.pushView();
  }
}
