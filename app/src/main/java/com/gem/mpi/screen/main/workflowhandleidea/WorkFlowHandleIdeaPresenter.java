package com.gem.mpi.screen.main.workflowhandleidea;

import android.os.Bundle;

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
}
