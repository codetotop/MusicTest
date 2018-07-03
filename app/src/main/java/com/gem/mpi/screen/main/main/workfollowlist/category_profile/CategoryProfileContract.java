package com.gem.mpi.screen.main.main.workfollowlist.category_profile;

import com.gem.mpi.data.dto.ListCategoryProfileDTO;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The CategoryProfile Contract
 */
interface CategoryProfileContract {

  interface Interactor extends IInteractor<Presenter> {
    void getListCategoryProfile(CommonCallback<ListCategoryProfileDTO> callback);
  }

  interface View extends PresentView<Presenter> {
    void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId,
                     Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId,
                     ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener);


    void finishFragment();

    void initListCategoryProfile();

    void showRefreshListCategoryProfile();

    void hideRefreshListCategoryProfile();

    void initRefreshListCategoryProfileListener();

    void moveToTopListCategoryProfile();
  }

  interface Presenter extends IPresenter<View, Interactor> {
    CategoryProfileAdaper getCategoryProfileAdaper();

    void handleRefreshListCategoryProfile();

    void handleActionLeft();

    void getListCategoryProfile();
  }
}



