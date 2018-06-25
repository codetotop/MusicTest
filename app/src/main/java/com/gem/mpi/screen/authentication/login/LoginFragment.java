package com.gem.mpi.screen.authentication.login;

import android.os.Bundle;
import android.text.InputType;

import com.gem.mpi.R;
import com.gem.mpi.widget.FormInputView;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;

/**
 * The Login Fragment
 */
public class LoginFragment extends ViewFragment<LoginContract.Presenter> implements LoginContract.View {
  @BindView(R.id.formInputUserName)
  FormInputView mformInputUserName;
  @BindView(R.id.formInputPassWord)
  FormInputView mformInputPassWord;
  public static LoginFragment getInstance() {
    return new LoginFragment();
  }

  public static LoginFragment getInstance(Bundle data) {
    LoginFragment loginFragment = new LoginFragment();
    loginFragment.setArguments(data);
    return loginFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_login;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    mformInputUserName.setAction("delete");
    mformInputPassWord.setAction("view");
    mformInputPassWord.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
  }
}
