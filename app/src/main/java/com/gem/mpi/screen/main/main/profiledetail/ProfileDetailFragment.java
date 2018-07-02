package com.gem.mpi.screen.main.main.profiledetail;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;

/**
 * The ProfileDetail Fragment
 */
public class ProfileDetailFragment extends ViewFragment<ProfileDetailContract.Presenter> implements ProfileDetailContract.View {

  @BindView(R.id.fragmentprofiledetail_tbv_toolbar)
  ToolbarView mToolbarTbv;

  public static ProfileDetailFragment getInstance() {
    return new ProfileDetailFragment();
  }

  public static ProfileDetailFragment getInstance(Bundle data) {
    ProfileDetailFragment profileDetailFragment = new ProfileDetailFragment();
    profileDetailFragment.setArguments(data);
    return profileDetailFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_profile_detail;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.TEXT, R.string.title_about_profile,
        R.drawable.ic_cancel, null, null, R.string.action_change,
        new ToolbarView.OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        },
        new ToolbarView.OnActionRightListener() {
          @Override
          public void onActionRightClick() {
            getPresenter().handleActionRight();
          }
        }
    );
  }

  @Override
  public void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId, Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId, ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener) {
    mToolbarTbv.init(actionLeftStyle, actionRightStyle, titleId,
        actionLeftDrawbleId, actionLeftStringId, actionRightDrawableId, actionRightStringId,
        onActionLeftListener, onActionRightListener);
  }
}
