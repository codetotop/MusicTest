package com.gem.mpi.screen.main.main.registration_business;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The RegistrationBusiness Contract
 */
interface RegistrationBusinessContract {

  interface Interactor extends IInteractor<Presenter> {
  }

  interface View extends PresentView<Presenter> {
    void initListRegistrationBusiness();
  }

  interface Presenter extends IPresenter<View, Interactor> {
    RegistrationBusinessAdapter getRegistrationBusinessAdapter();
  }
}



