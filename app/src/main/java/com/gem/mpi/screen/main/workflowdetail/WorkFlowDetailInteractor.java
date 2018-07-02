package com.gem.mpi.screen.main.workflowdetail;

import com.gemvietnam.base.viper.Interactor;

/**
 * The WorkFlow interactor
 */
class WorkFlowDetailInteractor extends Interactor<WorkFlowDetailContract.Presenter>
        implements WorkFlowDetailContract.Interactor {

    WorkFlowDetailInteractor(WorkFlowDetailContract.Presenter presenter) {
        super(presenter);
    }
}
