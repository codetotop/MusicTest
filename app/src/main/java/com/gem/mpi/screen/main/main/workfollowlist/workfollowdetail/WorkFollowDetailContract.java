package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail;

import com.gem.mpi.data.dto.WorkFlowDetailDTO;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

import java.util.ArrayList;

/**
 * The WorkFlow Contract
 */
interface WorkFollowDetailContract {

  interface Interactor extends IInteractor<Presenter> {
    void getWorkFlowDetailData(String work_flow_id, CommonCallback<WorkFlowDetailDTO> commonCallback);
  }

  interface View extends PresentView<Presenter> {
    void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId,
                     Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId,
                     ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener);
  }

  interface Presenter extends IPresenter<View, Interactor> {
    void getWorkFlowDetailData(String work_flow_id);
    void openHandleIdeaFragment();
    void handleActionLeft();
    void handleActionRight(ArrayList<String> documentRelation, ArrayList<String> documentIdeaHandle);
    void handleActionRight();
  }
}



