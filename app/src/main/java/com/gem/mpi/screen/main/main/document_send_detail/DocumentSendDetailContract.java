package com.gem.mpi.screen.main.main.document_send_detail;

import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The DocumentSendDetail Contract
 */
interface DocumentSendDetailContract {

  interface Interactor extends IInteractor<Presenter> {
  }

  interface View extends PresentView<Presenter> {
    void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId,
                     Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId,
                     ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener);
  }

  interface Presenter extends IPresenter<View, Interactor> {
    void handleActionLeft();

    void handleActionRight();
  }
}



