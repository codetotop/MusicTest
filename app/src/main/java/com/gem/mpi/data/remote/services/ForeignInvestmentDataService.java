package com.gem.mpi.data.remote.services;

import com.gem.mpi.data.dto.ListForeignInvestmentDataDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForeignInvestmentDataService {
  @GET("getdatadtnn")
  Call<BaseResponse<ListForeignInvestmentDataDTO>> getListForeignInvestmentDataDTO(@Query("year") int year);
}
