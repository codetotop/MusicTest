package com.gem.mpi.screen.main.main.workflowlist.workflowdetail.workflowhandleidea;

import android.os.Bundle;
import android.util.Log;

import com.gem.mpi.R;
import com.gem.mpi.data.dto.HandleIdeaDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.mapper.HandleIdeaMapper;
import com.gem.mpi.model.HandleIdeaModel;
import com.gem.mpi.pref.PrefWrapper;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The WorkFlowHandleIdea Presenter
 */
public class WorkFlowHandleIdeaPresenter extends Presenter<WorkFlowHandleIdeaContract.View, WorkFlowHandleIdeaContract.Interactor>
    implements WorkFlowHandleIdeaContract.Presenter {

  public WorkFlowHandleIdeaPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public WorkFlowHandleIdeaContract.Interactor onCreateInteractor() {
    return new WorkFlowHandleIdeaInteractor(this);
  }

  @Override
  public WorkFlowHandleIdeaContract.View onCreateView(Bundle data) {
    return WorkFlowHandleIdeaFragment.getInstance(data);
  }

  @Override
  public void handleActionLeft() {
    getView().finishFragment();
  }

  @Override
  public void sendIdea(String workFlowId, String handleIdea, Integer type) {
    if(handleIdea.isEmpty()){
      mView.showToast(R.string.handleidea_idea_empty);
      return;
    }
    mInteractor.sendIdea(workFlowId, handleIdea, type, new CommonCallback<HandleIdeaDTO>(getViewContext()) {
      @Override
      protected void onError(String errorMessage) {
        super.onError(errorMessage);
      }

      @Override
      protected void onSuccess(BaseResponse<HandleIdeaDTO> responseBody) {
        super.onSuccess(responseBody);
        HandleIdeaDTO handleIdeaDTO = responseBody.getData();
        HandleIdeaModel handleIdeaModel = HandleIdeaMapper.transform(handleIdeaDTO);
        PrefWrapper.saveHandleIdeaResponse(getViewContext(),handleIdeaDTO);
        mView.showToast(responseBody.getMessage());
        mView.finishFragment();
      }
    });
  }
}
