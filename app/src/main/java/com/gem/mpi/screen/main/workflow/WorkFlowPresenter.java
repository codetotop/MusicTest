package com.gem.mpi.screen.main.workflow;

import android.os.Bundle;

import com.gem.mpi.screen.main.workflowhandleidea.WorkFlowHandleIdeaPresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The WorkFlow Presenter
 */
public class WorkFlowPresenter extends Presenter<WorkFlowContract.View, WorkFlowContract.Interactor>
        implements WorkFlowContract.Presenter {

    public WorkFlowPresenter(ContainerView containerView) {
        super(containerView);
    }


    @Override
    public void start() {
        // Start getting data here
    }

    @Override
    public WorkFlowContract.Interactor onCreateInteractor() {
        return new WorkFlowInteractor(this);
    }

    @Override
    public WorkFlowContract.View onCreateView(Bundle data) {
        return WorkFlowFragment.getInstance();

    }

    @Override
    public void openHandleIdeaFragment() {
        new WorkFlowHandleIdeaPresenter(mContainerView).pushView();
    }
}
