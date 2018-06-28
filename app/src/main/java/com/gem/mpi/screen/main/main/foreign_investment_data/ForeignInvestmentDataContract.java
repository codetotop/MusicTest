package com.gem.mpi.screen.main.main.foreign_investment_data;

import com.gem.mpi.data.dto.ListForeignInvestmentDataDTO;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The ForeignInvestmentData Contract
 */
interface ForeignInvestmentDataContract {

  interface Interactor extends IInteractor<Presenter> {
    void getListForeignInvestmentData(int year, CommonCallback<ListForeignInvestmentDataDTO> callback);
  }

  interface View extends PresentView<Presenter> {
    void initListForeignInvestmentData();

    void moveToTopListForeignInvestmentData();

    void initRefreshListForeignInvestmentDataListener();

    void showRefreshListForeignInvestmentData();

    void hideRefreshListForeignInvestmentData();
  }

  interface Presenter extends IPresenter<View, Interactor> {
    ForeignInvestmentDataAdapter getForeignInvestmentDataAdapter();

    void getListForeignInvestmentData(int year);

    void handleRefreshListForeignInvestmentData();
  }
}



