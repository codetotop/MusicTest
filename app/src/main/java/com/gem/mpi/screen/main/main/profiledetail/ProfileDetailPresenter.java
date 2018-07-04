package com.gem.mpi.screen.main.main.profiledetail;

import android.os.Bundle;
import android.widget.Toast;

import com.gem.mpi.screen.main.main.profiledetail.update_profile.UpdateProfileFragment;
import com.gem.mpi.screen.main.main.profiledetail.update_profile.UpdateProfilePresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The ProfileDetail Presenter
 */
public class ProfileDetailPresenter extends Presenter<ProfileDetailContract.View, ProfileDetailContract.Interactor> implements ProfileDetailContract.Presenter,UpdateProfileFragment.OnBackListener {

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
    ((UpdateProfileFragment)updateProfilePresenter.getFragment()).setOnBackListener(this);
    updateProfilePresenter.pushView();
  }

  @Override
  public void onBackClick() {
    Toast.makeText(getViewContext(), "back", Toast.LENGTH_SHORT).show();
  }
}
