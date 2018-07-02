package com.gem.mpi.screen.main.main.profiledetail;

import com.gemvietnam.base.viper.Interactor;

/**
 * The ProfileDetail interactor
 */
class ProfileDetailInteractor extends Interactor<ProfileDetailContract.Presenter> implements ProfileDetailContract.Interactor {

  ProfileDetailInteractor(ProfileDetailContract.Presenter presenter) {
    super(presenter);
  }
}
