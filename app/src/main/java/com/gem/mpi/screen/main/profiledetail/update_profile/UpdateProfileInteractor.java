package com.gem.mpi.screen.main.profiledetail.update_profile;

import com.gemvietnam.base.viper.Interactor;

/**
 * The UpdateProfile interactor
 */
class UpdateProfileInteractor extends Interactor<UpdateProfileContract.Presenter> implements UpdateProfileContract.Interactor {

  UpdateProfileInteractor(UpdateProfileContract.Presenter presenter) {
    super(presenter);
  }
}
