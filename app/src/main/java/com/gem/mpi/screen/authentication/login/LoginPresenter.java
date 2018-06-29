package com.gem.mpi.screen.authentication.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.gem.mpi.R;
import com.gem.mpi.data.dto.LoginDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.mapper.LoginMapper;
import com.gem.mpi.model.LoginModel;
import com.gem.mpi.pref.PrefWrapper;
import com.gem.mpi.screen.authentication.forgot.ForgotPasswordPresenter;
import com.gem.mpi.screen.main.MainActivity;
import com.gem.mpi.screen.main.workflow.WorkFlowPresenter;
import com.gem.mpi.screen.main.workflowlist.WorkFlowListPresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.utils.StringUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The Login Presenter
 */
public class LoginPresenter extends Presenter<LoginContract.View, LoginContract.Interactor>
    implements LoginContract.Presenter {

  public LoginPresenter(ContainerView containerView) {
    super(containerView);
  }


  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public LoginContract.Interactor onCreateInteractor() {
    return new LoginInteractor(this);
  }

  @Override
  public LoginContract.View onCreateView(Bundle data) {
    return LoginFragment.getInstance(data);
  }

  @Override
  public void login(String username, String password) {
    if (checkValidate(username, password))
      return;
    mInteractor.login(username, password, new CommonCallback<LoginDTO>(getViewContext()) {
      @Override
      public void onResponse(@NonNull Response<BaseResponse<LoginDTO>> response) {
        super.onResponse(response);
      }

      @Override
      protected void onError(String errorMessage) {
        super.onError(errorMessage);
        mView.showToast("Error");
      }

      @Override
      protected void onSuccess(BaseResponse<LoginDTO> responseBody) {
        super.onSuccess(responseBody);
        LoginDTO loginDTO = responseBody.getData();
        LoginModel loginModel = LoginMapper.transform(loginDTO);
        Log.e("LOGIN_PRESENTER", "onSuccess: " + loginModel.getFuncitonModels().toString());
        PrefWrapper.saveLoginResponse(getViewContext(),loginDTO);
        mView.showToast(responseBody.getMessage());
        Intent intent = new Intent(getViewContext(), MainActivity.class);
        getViewContext().startActivity(intent);
      }
    });
  }

  private boolean checkValidate(String username, String password) {
    if (StringUtils.isEmpty(username)) {
      mView.showToast(R.string.validate_username);
      return true;
    } else if (StringUtils.isEmpty(password)) {
      mView.showToast(R.string.validate_password);
      return true;
    }
    return false;
  }

  @Override
  public void openScreenForgotPassWord() {
    //new ForgotPasswordPresenter(mContainerView).pushView();
    //new WorkFlowListPresenter(mContainerView).pushView();
    //new WorkFlowPresenter(mContainerView).pushView();
  }
}
