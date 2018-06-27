package com.gem.mpi.screen.main.main;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.profiledetail.ProfileDetailPresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.utils.ActivityUtils;

/**
 * The Main Presenter
 */
public class MainPresenter extends Presenter<MainContract.View, MainContract.Interactor> implements MainContract.Presenter {

  private SlideMenuAdaper mSlideMenuAdaper;

  public MainPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    mSlideMenuAdaper = new SlideMenuAdaper(null, getViewContext().getResources().getStringArray(R.array.menu_items));
    getView().initListSlideMenu();
    getView().onSlideMenuItemClick();
  }

  @Override
  public MainContract.Interactor onCreateInteractor() {
    return new MainInteractor(this);
  }

  @Override
  public MainContract.View onCreateView(Bundle data) {
    return MainFragment.getInstance(data);
  }

  @Override
  public SlideMenuAdaper getSlideMenuAdaper() {
    return mSlideMenuAdaper;
  }

  @Override
  public void handleActionLeft() {
    getView().onSlideMenuChange();
  }

  @Override
  public void handleLogout() {
    getView().showToast("LogOut");
  }

  @Override
  public void navigateToProfileDetail() {
    getView().onSlideMenuChange();
    ProfileDetailPresenter profileDetailPresenter = new ProfileDetailPresenter(mContainerView);
    profileDetailPresenter.pushView();
  }
}
