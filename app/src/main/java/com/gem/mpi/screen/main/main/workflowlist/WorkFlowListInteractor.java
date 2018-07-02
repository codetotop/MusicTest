package com.gem.mpi.screen.main.main.workflowlist;

import com.gemvietnam.base.viper.Interactor;

/**
 * The WorkFlowList interactor
 */
class WorkFlowListInteractor extends Interactor<WorkFlowListContract.Presenter>
        implements WorkFlowListContract.Interactor {

    WorkFlowListInteractor(WorkFlowListContract.Presenter presenter) {
        super(presenter);
    }
}
