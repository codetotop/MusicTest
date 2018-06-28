package com.gem.mpi.screen.main.category_profile;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The CategoryProfile Presenter
 */
public class CategoryProfilePresenter extends Presenter<CategoryProfileContract.View, CategoryProfileContract.Interactor> implements CategoryProfileContract.Presenter {

  public CategoryProfilePresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public CategoryProfileContract.Interactor onCreateInteractor() {
    return new CategoryProfileInteractor(this);
  }

  @Override
  public CategoryProfileContract.View onCreateView(Bundle data) {
    return CategoryProfileFragment.getInstance(data);
  }

  @Override
  public void handleActionLeft() {
    getView().finishFragment();
  }
}
