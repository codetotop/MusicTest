package com.gem.mpi.data.remote.services;

import com.gem.mpi.data.dto.ListRegistrationBusinessDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RegistrationBusinessService {
  @GET("GetDataDKDN")
  Call<BaseResponse<ListRegistrationBusinessDTO>> getListRegistrationBusiness(@Query("year") int year);
}
