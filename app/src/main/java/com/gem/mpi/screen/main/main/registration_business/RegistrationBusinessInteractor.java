package com.gem.mpi.screen.main.main.registration_business;

import com.gemvietnam.base.viper.Interactor;

/**
 * The RegistrationBusiness interactor
 */
class RegistrationBusinessInteractor extends Interactor<RegistrationBusinessContract.Presenter> implements RegistrationBusinessContract.Interactor {

  RegistrationBusinessInteractor(RegistrationBusinessContract.Presenter presenter) {
    super(presenter);
  }
}
