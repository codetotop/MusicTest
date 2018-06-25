package com.gem.mpi.screen.main.main;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The Main Presenter
 */
public class MainPresenter extends Presenter<MainContract.View, MainContract.Interactor>
    implements MainContract.Presenter {

  public MainPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    getView().initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_about_profile,
        R.drawable.ic_slide_menu, null, null, null,
        null, null
    );
    getView().initToolbarListener();
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
  public void handleActionLeft() {
    getView().initMenu();
  }

  @Override
  public void handleActionRight() {

  }
}
