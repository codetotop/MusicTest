package com.gem.mpi.screen.main.main.workfollowlist;

import com.gemvietnam.base.viper.Interactor;

/**
 * The WorkFlowList interactor
 */
class WorkFollowListInteractor extends Interactor<WorkFollowListContract.Presenter>
        implements WorkFollowListContract.Interactor {

    WorkFollowListInteractor(WorkFollowListContract.Presenter presenter) {
        super(presenter);
    }
}
