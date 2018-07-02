package com.gem.mpi.screen.main.main.registration_business;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.gem.mpi.data.dto.ListRegistrationBusinessDTO;
import com.gem.mpi.data.dto.RegistrationBusinessDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.mapper.RegistrationBusinessMapper;
import com.gem.mpi.model.RegistrationBusinessModel;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Response;

/**
 * The RegistrationBusiness Presenter
 */
public class RegistrationBusinessPresenter extends Presenter<RegistrationBusinessContract.View, RegistrationBusinessContract.Interactor> implements RegistrationBusinessContract.Presenter {
  private List<RegistrationBusinessModel> mListRegistrationBusinessModel;
  private RegistrationBusinessAdapter mRegistrationBusinessAdapter;
  private Calendar mCurrentDate;

  public RegistrationBusinessPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    initListRegistrationBusiness();
  }

  @Override
  public void handleRefreshListRegistrationBusiness() {
    initListRegistrationBusiness();
  }

  private void initListRegistrationBusiness() {
    mCurrentDate = Calendar.getInstance();
    mListRegistrationBusinessModel = new ArrayList<>();
    mRegistrationBusinessAdapter = new RegistrationBusinessAdapter(mListRegistrationBusinessModel);
    getView().initRefreshListRegistrationBusinessListener();
    getView().initListRegistrationBusiness();
    getListRegistrationBusiness(mCurrentDate.get(Calendar.YEAR));
  }

  @Override
  public RegistrationBusinessContract.Interactor onCreateInteractor() {
    return new RegistrationBusinessInteractor(this);
  }

  @Override
  public RegistrationBusinessContract.View onCreateView(Bundle data) {
    return RegistrationBusinessFragment.getInstance(data);
  }

  @Override
  public RegistrationBusinessAdapter getRegistrationBusinessAdapter() {
    return mRegistrationBusinessAdapter;
  }

  @Override
  public void getListRegistrationBusiness(int year) {
    getView().showRefreshListRegistrationBusiness();
    getInteractor().getListRegistrationBusiness(year, new CommonCallback<ListRegistrationBusinessDTO>(getViewContext()) {
      @Override
      public void onResponse(@NonNull Response<BaseResponse<ListRegistrationBusinessDTO>> response) {
        super.onResponse(response);
        updateListRegistrationBusinessUI(getListRegistrationBusinessModel(response));
      }
    });
  }

  private void updateListRegistrationBusinessUI(List<RegistrationBusinessModel> listRegistrationBusinessModel) {
    getView().hideRefreshListRegistrationBusiness();
    getView().moveToTopListRegistrationBusiness();
    mListRegistrationBusinessModel.clear();
    mRegistrationBusinessAdapter.notifyDataSetChanged();
    if (listRegistrationBusinessModel != null && !listRegistrationBusinessModel.isEmpty()) {
      mListRegistrationBusinessModel.addAll(listRegistrationBusinessModel);
      mRegistrationBusinessAdapter.notifyDataSetChanged();
    }
  }

  private List<RegistrationBusinessDTO> getListRegistrationBusinessDTO(Response<BaseResponse<ListRegistrationBusinessDTO>> response) {
    if (response == null || response.body() == null || response.body().getData() == null) {
      return null;
    }
    return response.body().getData().getListRegistrationBusiness();
  }

  private List<RegistrationBusinessModel> getListRegistrationBusinessModel
      (Response<BaseResponse<ListRegistrationBusinessDTO>> response) {
    return RegistrationBusinessMapper.transferToModel(getListRegistrationBusinessDTO(response));
  }
}
