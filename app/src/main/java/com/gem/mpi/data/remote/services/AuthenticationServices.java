package com.gem.mpi.data.remote.services;

import com.gem.mpi.data.dto.LoginDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.request.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationServices {
   @POST("login")
  Call<BaseResponse<LoginDTO>> handleLogin(@Body LoginRequest loginRequest);

}
