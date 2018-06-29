package com.gem.mpi.screen.authentication.login;

import android.os.Bundle;
import android.text.InputType;

import com.gem.mpi.R;
import com.gem.mpi.util.Constants;
import com.gem.mpi.widget.FormInputView;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * The Login Fragment
 */
public class LoginFragment extends ViewFragment<LoginContract.Presenter> implements LoginContract.View {
    @BindView(R.id.login_username_forminputview)
    FormInputView mformInputUserName;
    @BindView(R.id.login_password_formInputview)
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
        setLayoutDefault();

    }

    private void setLayoutDefault() {
        mformInputUserName.setText("");
        mformInputPassWord.setText("");
        mformInputUserName.setAction(Constants.LOGIN_ACTION_DELETE);
        mformInputPassWord.setAction(Constants.LOGIN_ACTION_VIEW);
        mformInputUserName.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        mformInputPassWord.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
    }

    @OnClick(R.id.login_btn_login)
    void onClickLogin() {
        mPresenter.login(mformInputUserName.getText(), mformInputPassWord.getText());
    }

    @OnClick(R.id.login_tv_forgot_password)
    void onClickForgotPassWord() {
        mPresenter.openScreenForgotPassWord();
    }

    @Override
    public void showMessageSuccess() {
        showToast(R.string.login_success_message);
    }

    @Override
    public void showMessageError() {
        showToast(R.string.login_error_message);

    }
}
