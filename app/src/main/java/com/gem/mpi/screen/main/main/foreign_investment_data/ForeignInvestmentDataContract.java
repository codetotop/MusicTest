package com.gem.mpi.screen.main.main.foreign_investment_data;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The ForeignInvestmentData Contract
 */
interface ForeignInvestmentDataContract {

  interface Interactor extends IInteractor<Presenter> {
  }

  interface View extends PresentView<Presenter> {
    void initListForeignInvestmentData();
  }

  interface Presenter extends IPresenter<View, Interactor> {
    ForeignInvestmentDataAdapter getForeignInvestmentDataAdapter();
  }
}



