package com.gem.mpi.screen.main.main;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gem.mpi.R;
import com.gem.mpi.widget.ToolbarView;
import com.gem.mpi.widget.ToolbarView.ActionStyle;
import com.gem.mpi.widget.ToolbarView.OnActionLeftListener;
import com.gem.mpi.widget.ToolbarView.OnActionRightListener;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * The Main Fragment
 */
public class MainFragment extends ViewFragment<MainContract.Presenter> implements MainContract.View {
  @BindView(R.id.fragmentmain_tbv_toolbar)
  ToolbarView mToolbarTbv;
  @BindView(R.id.fragmentmain_dl_drawer)
  DrawerLayout mDrawerDl;
  @BindView(R.id.fragmentmain_rv_list_slide_menu)
  RecyclerView mSlideMenuRv;

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
  public void onSlideMenuChange() {
    if (mDrawerDl.isDrawerOpen(GravityCompat.START)) {
      mDrawerDl.closeDrawer(GravityCompat.START);
    } else {
      mDrawerDl.openDrawer(GravityCompat.START);
    }
  }

  @Override
  @OnClick(R.id.fragmentmain_btn_logout)
  public void onLogoutClick() {
    getPresenter().handleLogout();
  }

  @Override
  public void initListSlideMenu() {
    mSlideMenuRv.setLayoutManager(new LinearLayoutManager(getViewContext()));
    mSlideMenuRv.setAdapter(getPresenter().getSlideMenuAdaper());
  }

  @Override
  @OnClick(R.id.viewprofile_iv_action)
  public void onSettingClick() {
    getPresenter().navigateToProfileDetail();
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_about_profile,
        R.drawable.ic_slide_menu, null, null, null,
        new OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        }, null
    );
  }
}
