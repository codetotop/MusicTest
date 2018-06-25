package com.gem.mpi.screen.authentication.login;

import android.os.Bundle;
import com.gem.mpi.R;
import com.gem.mpi.screen.base.AppBaseFragment;

/**
 * Created by BaVV on 20/11/2017.
 * LoginFragment
 */
public class LoginFragment extends AppBaseFragment<LoginContract.Presenter> implements LoginContract.View {

  public static LoginFragment getInstance(Bundle data) {
    return new LoginFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_login;
  }

  @Override
  public void initLayout() {
    super.initLayout();
  }
}
