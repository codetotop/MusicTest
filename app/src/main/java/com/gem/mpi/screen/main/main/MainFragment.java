package com.gem.mpi.screen.main.main;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.foreign_investment_data.ForeignInvestmentDataPresenter;
import com.gem.mpi.screen.main.main.registration_business.RegistrationBusinessPresenter;
import com.gem.mpi.screen.main.workflowlist.WorkFlowListPresenter;
import com.gem.mpi.widget.ToolbarView;
import com.gem.mpi.widget.ToolbarView.ActionStyle;
import com.gem.mpi.widget.ToolbarView.OnActionLeftListener;
import com.gem.mpi.widget.ToolbarView.OnActionRightListener;
import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.base.viper.interfaces.ContainerView;

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
  public void onSlideMenuItemClick() {
    getPresenter().getSlideMenuAdaper().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        onSlideMenuChange();
        switch ((int) view.getTag()) {
          case 0:
            break;
          case 1:
            break;
          case 2:
            WorkFlowListPresenter workFlowListPresenter = new WorkFlowListPresenter((ContainerView) getActivity());
            workFlowListPresenter.loadChildView(R.id.container_frame, getChildFragmentManager());
            break;
          case 3:

            break;
          case 4:
            RegistrationBusinessPresenter registrationBusinessPresenter = new RegistrationBusinessPresenter((ContainerView) getActivity());
            registrationBusinessPresenter.loadChildView(R.id.container_frame, getChildFragmentManager());
            break;
          case 5:
            ForeignInvestmentDataPresenter foreignInvestmentDataPresenter = new ForeignInvestmentDataPresenter((ContainerView) getActivity());
            foreignInvestmentDataPresenter.loadChildView(R.id.container_frame, getChildFragmentManager());
            break;
        }
      }
    });
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_work_flow,
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
