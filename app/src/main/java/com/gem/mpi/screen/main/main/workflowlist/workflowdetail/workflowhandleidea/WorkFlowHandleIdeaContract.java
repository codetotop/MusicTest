package com.gem.mpi.screen.main.main.workflowlist.workflowdetail.workflowhandleidea;

import com.gem.mpi.data.dto.HandleIdeaDTO;
import com.gem.mpi.data.remote.callback.BaseCallback;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.data.remote.request.HandleIdeaRequest;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The WorkFlowHandleIdea Contract
 */
interface WorkFlowHandleIdeaContract {

  interface Interactor extends IInteractor<Presenter> {
    void sendIdea(String workFlowId,String handleIdea,Integer type, CommonCallback<HandleIdeaDTO> callback);
  }

  interface View extends PresentView<Presenter> {
    void finishFragment();
    void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId,
                     Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId,
                     ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener);
  }

  interface Presenter extends IPresenter<View, Interactor> {
    void handleActionLeft();
    void sendIdea(String workFlowId,String handleIdea,Integer type);
  }
}


