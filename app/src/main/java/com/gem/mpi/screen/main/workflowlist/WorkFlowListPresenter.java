package com.gem.mpi.screen.main.workflowlist;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The WorkFlowList Presenter
 */
public class WorkFlowListPresenter extends Presenter<WorkFlowListContract.View, WorkFlowListContract.Interactor>
        implements WorkFlowListContract.Presenter {

    public WorkFlowListPresenter(ContainerView containerView) {
        super(containerView);
    }

    @Override
    public WorkFlowListContract.View onCreateView(Bundle data) {
        return WorkFlowListFragment.getInstance(data);
    }

    @Override
    public void start() {
        // Start getting data here
    }

    @Override
    public WorkFlowListContract.Interactor onCreateInteractor() {
        return new WorkFlowListInteractor(this);
    }
}
