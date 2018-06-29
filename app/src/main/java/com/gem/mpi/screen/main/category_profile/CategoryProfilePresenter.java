package com.gem.mpi.screen.main.category_profile;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import java.util.ArrayList;
import java.util.List;

/**
 * The CategoryProfile Presenter
 */
public class CategoryProfilePresenter extends Presenter<CategoryProfileContract.View, CategoryProfileContract.Interactor> implements CategoryProfileContract.Presenter {

  private List<CategoryProfileModel> mListCategoryProfileModel;
  private CategoryProfileAdaper mCategoryProfileAdapter;

  public CategoryProfilePresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    initListCategoryProfile();
  }

  private void initListCategoryProfile() {
    mListCategoryProfileModel = new ArrayList<>();
    mCategoryProfileAdapter = new CategoryProfileAdaper(mListCategoryProfileModel);
    getView().initListCategoryProfile();
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
  public CategoryProfileAdaper getCategoryProfileAdaper() {
    return mCategoryProfileAdapter;
  }

  @Override
  public void handleActionLeft() {
    getView().finishFragment();
  }
}
