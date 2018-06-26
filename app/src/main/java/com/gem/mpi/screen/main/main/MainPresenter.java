package com.gem.mpi.screen.main.main;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

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
    mSlideMenuAdaper = new SlideMenuAdaper(null);
    getView().initListSlideMenu();
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
    getView().onMenuClick();
  }

  @Override
  public void handleLogout() {
    getView().showToast("LogOut");
  }
}
