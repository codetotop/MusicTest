package com.gem.mpi.screen.main.main.workfollowlist.category_profile;

import com.gem.mpi.data.dto.ListCategoryProfileDTO;
import com.gem.mpi.data.remote.ServiceBuilder;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.Interactor;

/**
 * The CategoryProfile interactor
 */
class CategoryProfileInteractor extends Interactor<CategoryProfileContract.Presenter> implements CategoryProfileContract.Interactor {

  CategoryProfileInteractor(CategoryProfileContract.Presenter presenter) {
    super(presenter);
  }

  @Override
  public void getListCategoryProfile(CommonCallback<ListCategoryProfileDTO> callback) {
    ServiceBuilder.getCategoryProfileService().getListCategoryProfile().enqueue(callback);
  }
}
