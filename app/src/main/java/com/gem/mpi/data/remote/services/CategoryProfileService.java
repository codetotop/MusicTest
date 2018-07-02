package com.gem.mpi.data.remote.services;

import com.gem.mpi.data.dto.ListCategoryProfileDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryProfileService {
  @GET("GetListMenuWorkFollow")
  Call<BaseResponse<ListCategoryProfileDTO>> getListCategoryProfile();
}
