package com.gem.mpi.screen.main.main.foreign_investment_data;

import com.gemvietnam.base.viper.Interactor;

/**
 * The ForeignInvestmentData interactor
 */
class ForeignInvestmentDataInteractor extends Interactor<ForeignInvestmentDataContract.Presenter>
    implements ForeignInvestmentDataContract.Interactor {

  ForeignInvestmentDataInteractor(ForeignInvestmentDataContract.Presenter presenter) {
    super(presenter);
  }
}
