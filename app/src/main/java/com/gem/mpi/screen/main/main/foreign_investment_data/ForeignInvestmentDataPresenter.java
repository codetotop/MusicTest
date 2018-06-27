package com.gem.mpi.screen.main.main.foreign_investment_data;

import android.os.Bundle;
import android.os.Handler;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The ForeignInvestmentData Presenter
 */
public class ForeignInvestmentDataPresenter extends Presenter<ForeignInvestmentDataContract.View, ForeignInvestmentDataContract.Interactor> implements ForeignInvestmentDataContract.Presenter {

  private ForeignInvestmentDataAdapter mForeignInvestmentDataAdapter;

  public ForeignInvestmentDataPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    mForeignInvestmentDataAdapter = new ForeignInvestmentDataAdapter(null);
    getView().showProgress();
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        getView().initListForeignInvestmentDataAdapter();
        getView().hideProgress();
      }
    }, 300);
  }

  @Override
  public ForeignInvestmentDataContract.Interactor onCreateInteractor() {
    return new ForeignInvestmentDataInteractor(this);
  }

  @Override
  public ForeignInvestmentDataContract.View onCreateView(Bundle data) {
    return ForeignInvestmentDataFragment.getInstance(data);
  }

  @Override
  public ForeignInvestmentDataAdapter getForeignInvestmentDataAdapter() {
    return mForeignInvestmentDataAdapter;
  }
}
