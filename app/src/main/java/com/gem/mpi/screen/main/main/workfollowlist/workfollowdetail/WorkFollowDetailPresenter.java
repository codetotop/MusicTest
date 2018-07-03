package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.gem.mpi.data.dto.WorkFlowDetailDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.pref.PrefWrapper;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.documentrelation.DocumentRelationFragment;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.documentrelation.DocumentRelationPresenter;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model.DocumentModel;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model.HandleIdeaModel;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.workfollowhandleidea.WorkFollowHandleIdeaPresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * The WorkFlow Presenter
 */
public class WorkFollowDetailPresenter extends Presenter<WorkFollowDetailContract.View, WorkFollowDetailContract.Interactor>
    implements WorkFollowDetailContract.Presenter {

  public WorkFollowDetailPresenter(ContainerView containerView) {
    super(containerView);
  }


  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public WorkFollowDetailContract.Interactor onCreateInteractor() {
    return new WorkFollowDetailInteractor(this);
  }

  @Override
  public WorkFollowDetailContract.View onCreateView(Bundle data) {
    return WorkFollowDetailFragment.getInstance(data);

  }

  @Override
  public void getWorkFlowDetailData(String work_flow_id) {
    if (work_flow_id != null) {
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
    new WorkFollowHandleIdeaPresenter(mContainerView).pushView();
  }

  @Override
  public void handleActionLeft() {
    getFragment().getFragmentManager().popBackStack();
  }

  @Override
  public void handleActionRight(ArrayList<DocumentModel> documentRelation, ArrayList<HandleIdeaModel> handleIdeaModels) {

    ArrayList<DocumentModel> documentModels = new ArrayList<>();
    documentModels.addAll(documentRelation);
    for (HandleIdeaModel ideaModel : handleIdeaModels) {
      if (ideaModel.getDocumentRelationNames() != null)
        documentModels.addAll(ideaModel.getDocumentRelationNames());
    }

    Bundle bundle = new Bundle();
    bundle.putSerializable("documents",documentModels);
    DocumentRelationPresenter presenter = new DocumentRelationPresenter(mContainerView);
    presenter.getFragment().setArguments(bundle);
    presenter.pushView();
  }

}
