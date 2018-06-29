package com.gem.mpi.screen.main.profiledetail.update_profile;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;

/**
 * The UpdateProfile Fragment
 */
public class UpdateProfileFragment extends ViewFragment<UpdateProfileContract.Presenter> implements UpdateProfileContract.View {

  @BindView(R.id.fragmentupdateprofile_tbv_toolbar)
  ToolbarView mToolbarTbv;

  public static UpdateProfileFragment getInstance() {
    return new UpdateProfileFragment();
  }

  public static UpdateProfileFragment getInstance(Bundle data) {
    UpdateProfileFragment updateProfileFragment = new UpdateProfileFragment();
    updateProfileFragment.setArguments(data);
    return updateProfileFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_update_profile;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.TEXT, R.string.title_about_profile,
        R.drawable.ic_cancel, null, null, R.string.action_save,
        new ToolbarView.OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        }, null
    );
  }

  @Override
  public void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId, Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId, ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener) {
    mToolbarTbv.init(actionLeftStyle, actionRightStyle, titleId,
        actionLeftDrawbleId, actionLeftStringId, actionRightDrawableId, actionRightStringId,
        onActionLeftListener, onActionRightListener);
  }
}
