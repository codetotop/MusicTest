package com.gem.mpi.data.remote.callback;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by BaVV on 03/21/2018.
 */
public abstract class BaseCallback<T> implements Callback<T> {

  @Override
  public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
    onResponse(response);
  }

  protected abstract void onResponse(Response<T> response);
}
