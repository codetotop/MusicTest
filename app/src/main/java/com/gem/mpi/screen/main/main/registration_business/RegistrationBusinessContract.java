package com.gem.mpi.screen.main.main.registration_business;

import com.gem.mpi.data.dto.ListRegistrationBusinessDTO;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The RegistrationBusiness Contract
 */
interface RegistrationBusinessContract {

  interface Interactor extends IInteractor<Presenter> {
    void getListRegistrationBusiness(int year, CommonCallback<ListRegistrationBusinessDTO> callback);
  }

  interface View extends PresentView<Presenter> {
    void initListRegistrationBusiness();

    void moveToTopListRegistrationBusiness();

    void initRefreshListRegistrationBusinessListener();

    void showRefreshListRegistrationBusiness();

    void hideRefreshListRegistrationBusiness();
  }

  interface Presenter extends IPresenter<View, Interactor> {
    RegistrationBusinessAdapter getRegistrationBusinessAdapter();

    void getListRegistrationBusiness(int year);

    void handleRefreshListRegistrationBusiness();
  }
}



