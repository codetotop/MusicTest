package com.gem.mpi.screen.main.category_profile;

import com.gemvietnam.base.viper.Interactor;

/**
 * The CategoryProfile interactor
 */
class CategoryProfileInteractor extends Interactor<CategoryProfileContract.Presenter> implements CategoryProfileContract.Interactor {

  CategoryProfileInteractor(CategoryProfileContract.Presenter presenter) {
    super(presenter);
  }
}
