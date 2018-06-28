package com.gem.mpi.screen.main.main.registration_business;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.MainFragment;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;

/**
 * The RegistrationBusiness Fragment
 */
public class RegistrationBusinessFragment extends ViewFragment<RegistrationBusinessContract.Presenter> implements RegistrationBusinessContract.View {
  @BindView(R.id.fragmentregistrationbusiness_rv_list_registration_business)
  RecyclerView mListRegistrationBusinessRv;
  @BindView(R.id.fragmentregistrationbusiness_srl_refresh_list_registration_business)
  SwipeRefreshLayout mRefreshListRegistrationBusiness;

  public static RegistrationBusinessFragment getInstance() {
    return new RegistrationBusinessFragment();
  }

  public static RegistrationBusinessFragment getInstance(Bundle data) {
    RegistrationBusinessFragment registrationBusinessFragment = new RegistrationBusinessFragment();
    registrationBusinessFragment.setArguments(data);
    return registrationBusinessFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_registration_business;
  }

  @Override
  public void initListRegistrationBusiness() {
    mRefreshListRegistrationBusiness.setColorSchemeColors(Color.GREEN);
    mListRegistrationBusinessRv.setLayoutManager(new LinearLayoutManager(getViewContext()));
    mListRegistrationBusinessRv.setAdapter(getPresenter().getRegistrationBusinessAdapter());
  }

  @Override
  public void moveToTopListRegistrationBusiness() {
    mListRegistrationBusinessRv.scrollToPosition(0);
  }

  @Override
  public void initRefreshListRegistrationBusinessListener() {
    mRefreshListRegistrationBusiness.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        getPresenter().handleRefreshListRegistrationBusiness();
      }
    });
  }

  @Override
  public void showRefreshListRegistrationBusiness() {
    if (!mRefreshListRegistrationBusiness.isRefreshing()) {
      mRefreshListRegistrationBusiness.setRefreshing(true);
    }
  }

  @Override
  public void hideRefreshListRegistrationBusiness() {
    if (mRefreshListRegistrationBusiness.isRefreshing()) {
      mRefreshListRegistrationBusiness.setRefreshing(false);
    }
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    if (getParentFragment() != null && getParentFragment() instanceof MainFragment) {
      ((MainFragment) getParentFragment()).initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_business_registration,
          R.drawable.ic_slide_menu, null, null, null, null, null
      );
    }
  }
}
