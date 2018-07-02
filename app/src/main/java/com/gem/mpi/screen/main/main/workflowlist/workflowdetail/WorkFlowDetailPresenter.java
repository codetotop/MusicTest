package com.gem.mpi.screen.main.main.workflowlist.workflowdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.gem.mpi.data.dto.WorkFlowDetailDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.data.remote.services.WorkFlowServices;
import com.gem.mpi.screen.main.main.workflowlist.workflowdetail.documentrelation.DocumentRelationPresenter;
import com.gem.mpi.screen.main.main.workflowlist.workflowdetail.workflowhandleidea.WorkFlowHandleIdeaPresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * The WorkFlow Presenter
 */
public class WorkFlowDetailPresenter extends Presenter<WorkFlowDetailContract.View, WorkFlowDetailContract.Interactor>
    implements WorkFlowDetailContract.Presenter {

  public WorkFlowDetailPresenter(ContainerView containerView) {
    super(containerView);
  }


  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public WorkFlowDetailContract.Interactor onCreateInteractor() {
    return new WorkFlowDetailInteractor(this);
  }

  @Override
  public WorkFlowDetailContract.View onCreateView(Bundle data) {
    return WorkFlowDetailFragment.getInstance();

  }

  @Override
  public void getWorkFlowDetailData(String work_flow_id) {
    if (work_flow_id != null){
      mInteractor.getWorkFlowDetailData(work_flow_id, new CommonCallback<WorkFlowDetailDTO>(getViewContext()) {
        @Override
        public void onFailure(@NonNull Call<BaseResponse<WorkFlowDetailDTO>> call, @NonNull Throwable t) {
          super.onFailure(call, t);
        }

        @Override
        protected void onSuccess(BaseResponse<WorkFlowDetailDTO> responseBody) {
          super.onSuccess(responseBody);
          WorkFlowDetailDTO workFlowDetailDTO = responseBody.getData();
        }
      });
    }
  }

  @Override
  public void openHandleIdeaFragment() {
    new WorkFlowHandleIdeaPresenter(mContainerView).pushView();
  }

  @Override
  public void handleActionLeft() {
    getFragment().getFragmentManager().popBackStack();
  }

  @Override
  public void handleActionRight(ArrayList<String> documentRelation, ArrayList<String> documentIdeaHandle) {
    /*new DocumentRelationPresenter(mContainerView).pushView();
    getFragment().getFragmentManager().putFragment();*/
  }

  @Override
  public void handleActionRight() {
    new DocumentRelationPresenter(mContainerView).pushView();
  }

}
