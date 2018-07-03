package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.workfollowhandleidea;

import android.os.Bundle;

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
public class WorkFollowHandleIdeaPresenter extends Presenter<WorkFollowHandleIdeaContract.View, WorkFollowHandleIdeaContract.Interactor>
    implements WorkFollowHandleIdeaContract.Presenter {

  public WorkFollowHandleIdeaPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public WorkFollowHandleIdeaContract.Interactor onCreateInteractor() {
    return new WorkFollowHandleIdeaInteractor(this);
  }

  @Override
  public WorkFollowHandleIdeaContract.View onCreateView(Bundle data) {
    return WorkFollowHandleIdeaFragment.getInstance(data);
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
