package com.gem.mpi.screen.main.main.workflowlist.workflowdetail;

import android.os.Bundle;

import com.gem.mpi.screen.main.main.workflowlist.workflowdetail.workflowhandleidea.WorkFlowHandleIdeaPresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

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
  public void openHandleIdeaFragment() {
    new WorkFlowHandleIdeaPresenter(mContainerView).pushView();
  }

  @Override
  public void handleActionLeft() {
    getFragment().getFragmentManager().popBackStack();
  }

  @Override
  public void handleActionRight() {

  }

}
