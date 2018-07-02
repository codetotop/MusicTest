package com.gem.mpi.screen.main.category_profile;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.gem.mpi.data.dto.CategoryProfileDTO;
import com.gem.mpi.data.dto.ListCategoryProfileDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.mapper.CategoryProfileMapper;
import com.gem.mpi.model.CategoryProfileModel;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

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

  @Override
  public void handleRefreshListCategoryProfile() {
    initListCategoryProfile();
  }

  private void initListCategoryProfile() {
    mListCategoryProfileModel = new ArrayList<>();
    mCategoryProfileAdapter = new CategoryProfileAdaper(mListCategoryProfileModel);
    getView().initListCategoryProfile();
    getView().initRefreshListCategoryProfileListener();
    getListCategoryProfile();
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

  @Override
  public void getListCategoryProfile() {
    getView().showRefreshListCategoryProfile();
    getInteractor().getListCategoryProfile(new CommonCallback<ListCategoryProfileDTO>(getViewContext()) {
      @Override
      public void onResponse(@NonNull Response<BaseResponse<ListCategoryProfileDTO>> response) {
        super.onResponse(response);
        updateListCategoryProfileUI(getListCategoryProfileModel(response));
      }
    });
  }

  private void updateListCategoryProfileUI(List<CategoryProfileModel> listCategoryProfileModel) {
    getView().hideRefreshListCategoryProfile();
    getView().moveToTopListCategoryProfile();
    mListCategoryProfileModel.clear();
    mCategoryProfileAdapter.notifyDataSetChanged();
    if (listCategoryProfileModel != null && !listCategoryProfileModel.isEmpty()) {
      mListCategoryProfileModel.addAll(listCategoryProfileModel);
      mCategoryProfileAdapter.notifyDataSetChanged();
    }
  }

  private List<CategoryProfileDTO> getListCategoryProfileDTO(Response<BaseResponse<ListCategoryProfileDTO>> response) {
    if (response == null || response.body() == null || response.body().getData() == null) {
      return null;
    }
    return response.body().getData().getListCategoryProfile();
  }

  private List<CategoryProfileModel> getListCategoryProfileModel(Response<BaseResponse<ListCategoryProfileDTO>> response) {
    return CategoryProfileMapper.transferToModel(getListCategoryProfileDTO(response));
  }
}
