package com.gem.mpi.screen.main.category_profile;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gem.mpi.widget.ToolbarView;
import com.gem.mpi.widget.ToolbarView.ActionStyle;
import com.gem.mpi.widget.ToolbarView.OnActionLeftListener;
import com.gem.mpi.widget.ToolbarView.OnActionRightListener;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;

/**
 * The CategoryProfile Fragment
 */
public class CategoryProfileFragment extends ViewFragment<CategoryProfileContract.Presenter> implements CategoryProfileContract.View {
  @BindView(R.id.fragmentcategoryprofile_tbv_toolbar)
  ToolbarView mToolbarTbv;

  public static CategoryProfileFragment getInstance() {
    return new CategoryProfileFragment();
  }

  public static CategoryProfileFragment getInstance(Bundle data) {
    CategoryProfileFragment categoryProfileFragment = new CategoryProfileFragment();
    categoryProfileFragment.setArguments(data);
    return categoryProfileFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_category_profile;
  }


  @Override
  public void initToolbar(ActionStyle actionLeftStyle, ActionStyle actionRightStyle, Integer titleId, Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId, OnActionLeftListener onActionLeftListener, OnActionRightListener onActionRightListener) {
    mToolbarTbv.init(actionLeftStyle, actionRightStyle, titleId,
        actionLeftDrawbleId, actionLeftStringId, actionRightDrawableId, actionRightStringId,
        onActionLeftListener, onActionRightListener);
  }

  @Override
  public void finishFragment() {
    if (getFragmentManager() != null) {
      getFragmentManager().popBackStack();
    }
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolbar(ActionStyle.IMAGE, ActionStyle.NONE, R.string.title_category_profile,
        R.drawable.ic_cancel, null, null, null,
        new OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        }, null
    );
  }
}
