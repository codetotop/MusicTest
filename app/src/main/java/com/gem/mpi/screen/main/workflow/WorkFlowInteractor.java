package com.gem.mpi.screen.main.workflow;

import com.gemvietnam.base.viper.Interactor;

/**
 * The WorkFlow interactor
 */
class WorkFlowInteractor extends Interactor<WorkFlowContract.Presenter>
        implements WorkFlowContract.Interactor {

    WorkFlowInteractor(WorkFlowContract.Presenter presenter) {
        super(presenter);
    }
}
