package com.gem.mpi.screen.main.main;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import com.gem.mpi.R;
import com.gem.mpi.widget.ToolbarView;
import com.gem.mpi.widget.ToolbarView.ActionStyle;
import com.gem.mpi.widget.ToolbarView.OnActionLeftListener;
import com.gem.mpi.widget.ToolbarView.OnActionRightListener;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;

/**
 * The Main Fragment
 */
public class MainFragment extends ViewFragment<MainContract.Presenter> implements MainContract.View {
  @BindView(R.id.fragmentmain_tv_toolbar)
  ToolbarView mToolbarTbv;
  @BindView(R.id.fragmentmain_dl_drawer)
  DrawerLayout mDrawerDl;

  public static MainFragment getInstance() {
    return new MainFragment();
  }

  public static MainFragment getInstance(Bundle data) {
    MainFragment mainFragment = new MainFragment();
    mainFragment.setArguments(data);
    return mainFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_main;
  }

  @Override
  public void initToolbar(ActionStyle actionLeftStyle, ActionStyle actionRightStyle, Integer titleId,
                          Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId,
                          OnActionLeftListener onActionLeftListener, OnActionRightListener onActionRightListener) {
    mToolbarTbv.init(actionLeftStyle, actionRightStyle, titleId,
        actionLeftDrawbleId, actionLeftStringId, actionRightDrawableId, actionRightStringId,
        onActionLeftListener, onActionRightListener);
  }

  @Override
  public void initMenu() {
    if (mDrawerDl.isDrawerOpen(GravityCompat.START)) {
      mDrawerDl.closeDrawer(GravityCompat.START);
    } else {
      mDrawerDl.openDrawer(GravityCompat.START);
    }
  }

  @Override
  public void initToolbarListener() {
    mToolbarTbv.initListener(new OnActionLeftListener() {
      @Override
      public void onActionLeftClick() {
        getPresenter().handleActionLeft();
      }
    }, null);
  }
}
