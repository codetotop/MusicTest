package com.gem.mpi.screen.main.home;

import com.gem.mpi.data.dto.LocationDTO;
import com.gem.mpi.data.remote.ServiceBuilder;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.Interactor;

/**
 * The Home interactor
 */
class HomeInteractor extends Interactor<HomeContract.Presenter>
    implements HomeContract.Interactor {

  HomeInteractor(HomeContract.Presenter presenter) {
    super(presenter);
  }

  @Override
  public void getLocationSetting(CommonCallback<LocationDTO> callback) {
    ServiceBuilder.getLocationService().getLocationSetting().enqueue(callback);
  }
}
