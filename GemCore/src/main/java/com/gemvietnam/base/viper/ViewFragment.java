package com.gemvietnam.base.viper;

import com.gemvietnam.base.BaseActivity;
import com.gemvietnam.base.BaseFragment;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.common.R;
import com.gemvietnam.utils.ContextUtils;
import com.gemvietnam.utils.DialogUtils;
import com.gemvietnam.utils.NetworkUtils;
import com.gemvietnam.utils.ViewUtils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Fragments that stand for View
 * Created by neo on 9/15/2016.
 */
public abstract class ViewFragment<P extends IPresenter>
        extends BaseFragment implements PresentView<P> {
  protected P mPresenter;
  protected boolean mIsInitialized = false;
  private boolean mViewHidden;
  private Toast mToast;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mPresenter.registerEventBus();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mPresenter.unregisterEventBus();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    if (!mIsInitialized) {
      mRootView = super.onCreateView(inflater, container, savedInstanceState);

      // Prepare layout
      if (getArguments() != null) {
        parseArgs(getArguments());
      }

      initLayout();
      ViewUtils.setupUI(mRootView, getActivity());
      mIsInitialized = true;
    }

    return mRootView;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    if (!mStartOnAnimationEnded && !mIsStarted) {
      startPresent();
    }
  }

  @Override
  protected void startPresent() {
    mPresenter.start();
    mIsStarted = true;
  }

  @Override
  public void showProgress() {
    if (ContextUtils.isValidContext(getBaseActivity())) {
      getBaseActivity().showProgress();
    }
  }

  @Override
  public void hideProgress() {
    if (ContextUtils.isValidContext(getBaseActivity())) {
      getBaseActivity().hideProgress();
    }
  }

  @Override
  public void initLayout() {
    // Override this method when need to preview some views, layouts
  }

  @Override
  public void showAlertDialog(String message) {
    if (ContextUtils.isValidContext(getBaseActivity())) {
      getBaseActivity().showAlertDialog(message);
    }
  }

  @Override
  public BaseActivity getBaseActivity() {
    if (getActivity() instanceof BaseActivity) {
      return (BaseActivity) getActivity();
    } else {
      return null;
    }
  }

  @Override
  public void onRequestError(String errorCode, String errorMessage) {
    if (ContextUtils.isValidContext(getBaseActivity())) {
      getBaseActivity().onRequestError(errorCode, errorMessage);
    }
  }

  @Override
  public void onNetworkError(boolean shouldShowPopup) {
    if (!NetworkUtils.isNoNetworkAvailable(getActivity(), shouldShowPopup)) {
      DialogUtils.showErrorAlert(getActivity(), getString(R.string.msg_network_lost));
    }
  }

  @Override
  public void onRequestSuccess() {
    if (ContextUtils.isValidContext(getBaseActivity())) {
      getBaseActivity().onRequestSuccess();
    }
  }

  @Override
  public Activity getViewContext() {
    return getActivity();
  }

  @Override
  public Bundle getData() {
    return getArguments();
  }

  @Override
  public void setPresenter(P presenter) {
    mPresenter = presenter;
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  /**
   * Parse Arguments that sent to this fragment
   * Override if needed
   *
   * @param args sent to this fragment
   */
  protected void parseArgs(Bundle args) {
  }

  @Override
  protected boolean needTranslationAnimation() {
    return true;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    mPresenter.onFragmentDisplay();
  }

  @Override
  public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    mViewHidden = hidden;
  }

  @Override
  public boolean isViewHidden() {
    return mViewHidden;
  }

  @Override
  public boolean isShowing() {
    return isResumed() && this == BaseActivity.getTopFragment(getFragmentManager());
  }

  @Override
  public void showToast(String msg) {
    if (mToast != null){
      mToast.cancel();
    }
    mToast = Toast.makeText(getViewContext(), msg, Toast.LENGTH_LONG);
    mToast.show();
  }
}
