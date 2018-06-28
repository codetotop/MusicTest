package com.gem.mpi.screen.main.main.registration_business;

import com.gem.mpi.data.dto.ListRegistrationBusinessDTO;
import com.gem.mpi.data.remote.ServiceBuilder;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.Interactor;

/**
 * The RegistrationBusiness interactor
 */
class RegistrationBusinessInteractor extends Interactor<RegistrationBusinessContract.Presenter> implements RegistrationBusinessContract.Interactor {

  RegistrationBusinessInteractor(RegistrationBusinessContract.Presenter presenter) {
    super(presenter);
  }


  @Override
  public void getListRegistrationBusiness(int year, CommonCallback<ListRegistrationBusinessDTO> callback) {
    ServiceBuilder.getRegistrationBusinessService().getListRegistrationBusiness(year).enqueue(callback);
  }
}
