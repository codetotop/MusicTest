package com.gem.mpi.data.remote.services;

import com.gem.mpi.data.dto.LocationDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by BaVV on 03/21/2018.
 * LocationService
 */

public interface LocationService {

  String SERVICE_NAME = "queries/Merit.Components.Locations.Queries/LocationQueries";

  @GET("GetSurveyLocation/results")
  Call<BaseResponse<LocationDTO>> getLocationSetting();
}