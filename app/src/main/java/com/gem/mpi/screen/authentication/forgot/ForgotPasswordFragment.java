package com.gem.mpi.screen.authentication.forgot;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

/**
 * The ForgotPassword Fragment
 */
public class ForgotPasswordFragment extends ViewFragment<ForgotPasswordContract.Presenter> implements ForgotPasswordContract.View {

    public static ForgotPasswordFragment getInstance() {
        return new ForgotPasswordFragment();
    }
    public static ForgotPasswordFragment getInstance(Bundle data) {
        return new ForgotPasswordFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_forgot_password;
    }


}
