package com.gem.mpi.screen.main.main.workflowlist.workflowdetail.workflowhandleidea;

import com.gem.mpi.data.dto.HandleIdeaDTO;
import com.gem.mpi.data.remote.ServiceBuilder;
import com.gem.mpi.data.remote.callback.BaseCallback;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.data.remote.request.HandleIdeaRequest;
import com.gemvietnam.base.viper.Interactor;
import com.google.gson.annotations.SerializedName;

/**
 * The WorkFlowHandleIdea interactor
 */
class WorkFlowHandleIdeaInteractor extends Interactor<WorkFlowHandleIdeaContract.Presenter>
    implements WorkFlowHandleIdeaContract.Interactor {

  WorkFlowHandleIdeaInteractor(WorkFlowHandleIdeaContract.Presenter presenter) {
    super(presenter);
  }

  @Override
  public void sendIdea(String workFlowId,String handleIdea,Integer type, CommonCallback<HandleIdeaDTO> callback) {
    HandleIdeaRequest handleIdeaRequest = new HandleIdeaRequest();
    handleIdeaRequest.setWorkFlowId(workFlowId);
    handleIdeaRequest.setHandleIdea(handleIdea);
    handleIdeaRequest.setType(type);
    ServiceBuilder.getWorkFlowService().handlleIdea(handleIdeaRequest).enqueue(callback);
  }
}
