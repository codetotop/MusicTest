package com.gem.mpi.screen.main.main.foreign_investment_data;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.gem.mpi.data.dto.ForeignInvestmentDataDTO;
import com.gem.mpi.data.dto.ListForeignInvestmentDataDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.mapper.ForeignInvestmentDataMapper;
import com.gem.mpi.model.ForeignInvestmentDataModel;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Response;

/**
 * The ForeignInvestmentData Presenter
 */
public class ForeignInvestmentDataPresenter extends Presenter<ForeignInvestmentDataContract.View, ForeignInvestmentDataContract.Interactor> implements ForeignInvestmentDataContract.Presenter {

  private List<ForeignInvestmentDataModel> mListForeignInvestmentDataModel;
  private ForeignInvestmentDataAdapter mForeignInvestmentDataAdapter;
  private Calendar mCurrentDate;

  public ForeignInvestmentDataPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    initListForeignInvestmentData();
  }

  @Override
  public void handleRefreshListForeignInvestmentData() {
    initListForeignInvestmentData();
  }

  private void initListForeignInvestmentData() {
    mCurrentDate = Calendar.getInstance();
    mListForeignInvestmentDataModel = new ArrayList<>();
    mForeignInvestmentDataAdapter = new ForeignInvestmentDataAdapter(mListForeignInvestmentDataModel);
    getView().initListForeignInvestmentData();
    getView().initRefreshListForeignInvestmentDataListener();
    getListForeignInvestmentData(mCurrentDate.get(Calendar.YEAR));
  }

  @Override
  public ForeignInvestmentDataContract.Interactor onCreateInteractor() {
    return new ForeignInvestmentDataInteractor(this);
  }

  @Override
  public ForeignInvestmentDataContract.View onCreateView(Bundle data) {
    return ForeignInvestmentDataFragment.getInstance(data);
  }

  @Override
  public ForeignInvestmentDataAdapter getForeignInvestmentDataAdapter() {
    return mForeignInvestmentDataAdapter;
  }

  @Override
  public void getListForeignInvestmentData(int year) {
    getView().showRefreshListForeignInvestmentData();
    getInteractor().getListForeignInvestmentData(year, new CommonCallback<ListForeignInvestmentDataDTO>(getViewContext()) {
      @Override
      public void onResponse(@NonNull Response<BaseResponse<ListForeignInvestmentDataDTO>> response) {
        super.onResponse(response);
        updateListForeignInvestmentData(getListForeignInvestmentDataModel(response));
      }
    });
  }

  private void updateListForeignInvestmentData(List<ForeignInvestmentDataModel> listForeignInvestmentDataModel) {
    getView().hideRefreshListForeignInvestmentData();
    getView().moveToTopListForeignInvestmentData();
    mListForeignInvestmentDataModel.clear();
    mForeignInvestmentDataAdapter.notifyDataSetChanged();
    if (listForeignInvestmentDataModel != null && !listForeignInvestmentDataModel.isEmpty()) {
      mListForeignInvestmentDataModel.addAll(listForeignInvestmentDataModel);
      mForeignInvestmentDataAdapter.notifyDataSetChanged();
    }
  }

  private List<ForeignInvestmentDataDTO> getListForeignInvestmentDataDTO(Response<BaseResponse<ListForeignInvestmentDataDTO>> response) {
    List<ForeignInvestmentDataDTO> listForeignInvestmentDataDTO = new ArrayList<>();
    if (response == null || response.body() == null || response.body().getData() == null) {
      return listForeignInvestmentDataDTO;
    }
    return response.body().getData().getCompanyRegisterNn();
  }

  private List<ForeignInvestmentDataModel> getListForeignInvestmentDataModel(Response<BaseResponse<ListForeignInvestmentDataDTO>> response) {
    return ForeignInvestmentDataMapper.transferToModel(getListForeignInvestmentDataDTO(response));
  }
}
