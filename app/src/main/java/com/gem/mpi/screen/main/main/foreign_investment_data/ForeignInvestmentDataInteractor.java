package com.gem.mpi.screen.main.main.foreign_investment_data;

import com.gem.mpi.data.dto.ListForeignInvestmentDataDTO;
import com.gem.mpi.data.remote.ServiceBuilder;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.Interactor;

/**
 * The ForeignInvestmentData interactor
 */
class ForeignInvestmentDataInteractor extends Interactor<ForeignInvestmentDataContract.Presenter> implements ForeignInvestmentDataContract.Interactor {

  ForeignInvestmentDataInteractor(ForeignInvestmentDataContract.Presenter presenter) {
    super(presenter);
  }

  @Override
  public void getListForeignInvestmentData(int year, CommonCallback<ListForeignInvestmentDataDTO> callback) {
    ServiceBuilder.getForeignInvestmentDataService().getListForeignInvestmentDataDTO(year).enqueue(callback);
  }
}
