package com.gem.mpi.screen.main.main;

import com.gem.mpi.widget.ToolbarView.ActionStyle;
import com.gem.mpi.widget.ToolbarView.OnActionLeftListener;
import com.gem.mpi.widget.ToolbarView.OnActionRightListener;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The Main Contract
 */
interface MainContract {

  interface Interactor extends IInteractor<Presenter> {

  }

  interface View extends PresentView<Presenter> {
    void initToolbar(ActionStyle actionLeftStyle, ActionStyle actionRightStyle, Integer titleId,
                     Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId,
                     OnActionLeftListener onActionLeftListener, OnActionRightListener onActionRightListener);

    void onSlideMenuChange();

    void onLogoutClick();

    void initListSlideMenu();

    void onSettingClick();
  }

  interface Presenter extends IPresenter<View, Interactor> {
    SlideMenuAdaper getSlideMenuAdaper();

    void handleActionLeft();

    void handleLogout();

    void navigateToProfileDetail();
  }
}



