package com.gem.mpi.screen.main.main.foreign_investment_data;

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
 * The ForeignInvestmentData Fragment
 */
public class ForeignInvestmentDataFragment extends ViewFragment<ForeignInvestmentDataContract.Presenter> implements ForeignInvestmentDataContract.View {

  @BindView(R.id.fragmentforeigninvestmentdata_rv_list_foreigninvestmentdata)
  RecyclerView mListForeignInvestmentDataRv;
  @BindView(R.id.fragmentforeigninvestmentdata_srl_refresh_list_foreigninvestmentdata)
  SwipeRefreshLayout mRefreshListForeignInvestmentDataSrl;

  public static ForeignInvestmentDataFragment getInstance() {
    return new ForeignInvestmentDataFragment();
  }

  public static ForeignInvestmentDataFragment getInstance(Bundle data) {
    ForeignInvestmentDataFragment foreignInvestmentDataFragment = new ForeignInvestmentDataFragment();
    foreignInvestmentDataFragment.setArguments(data);
    return foreignInvestmentDataFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_foreign_investment_data;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    if (getParentFragment() != null && getParentFragment() instanceof MainFragment) {
      ((MainFragment) getParentFragment()).initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_foreign_investment_data,
          R.drawable.ic_slide_menu, null, null, null, null, null
      );
    }
  }

  @Override
  public void initListForeignInvestmentData() {
    mRefreshListForeignInvestmentDataSrl.setColorSchemeResources(R.color.bgBlueMonthHeader);
    mListForeignInvestmentDataRv.setLayoutManager(new LinearLayoutManager(getViewContext()));
    mListForeignInvestmentDataRv.setAdapter(getPresenter().getForeignInvestmentDataAdapter());
  }

  @Override
  public void moveToTopListForeignInvestmentData() {
    mListForeignInvestmentDataRv.scrollToPosition(0);
  }

  @Override
  public void initRefreshListForeignInvestmentDataListener() {
    mRefreshListForeignInvestmentDataSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        getPresenter().handleRefreshListForeignInvestmentData();
      }
    });
  }

  @Override
  public void showRefreshListForeignInvestmentData() {
    if (!mRefreshListForeignInvestmentDataSrl.isRefreshing()) {
      mRefreshListForeignInvestmentDataSrl.setRefreshing(true);
    }
  }

  @Override
  public void hideRefreshListForeignInvestmentData() {
    if (mRefreshListForeignInvestmentDataSrl.isRefreshing()) {
      mRefreshListForeignInvestmentDataSrl.setRefreshing(false);
    }
  }
}
