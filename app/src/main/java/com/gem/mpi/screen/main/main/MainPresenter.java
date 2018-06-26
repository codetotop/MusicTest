package com.gem.mpi.screen.main.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.profiledetail.ProfileDetailFragment;
import com.gem.mpi.screen.main.profiledetail.ProfileDetailPresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.utils.ActivityUtils;

import java.util.List;

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
    ActivityUtils.addFragmentToActivity(getFragment().getFragmentManager(), profileDetailPresenter.getFragment(), R.id.container_frame, true, "" + ProfileDetailFragment.class.getName());
    Fragment a=getTopFragment(getFragment().getFragmentManager());
    Log.d("Test",a.toString());
  }

  public static Fragment getTopFragment(FragmentManager manager) {
    if (manager != null) {
      if (manager.getBackStackEntryCount() > 0) {
        FragmentManager.BackStackEntry backStackEntry = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1);
        if (null != backStackEntry) {
          return manager.findFragmentByTag(backStackEntry.getName());
        }
      } else {
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null && fragments.size() > 0) {
          return fragments.get(0);
        }
      }
    }
    return null;
  }
}
