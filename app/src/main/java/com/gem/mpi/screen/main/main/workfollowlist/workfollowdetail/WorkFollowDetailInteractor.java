package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail;

import com.gem.mpi.data.dto.WorkFlowDetailDTO;
import com.gem.mpi.data.remote.ServiceBuilder;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.Interactor;

/**
 * The WorkFlow interactor
 */
class WorkFollowDetailInteractor extends Interactor<WorkFollowDetailContract.Presenter>
        implements WorkFollowDetailContract.Interactor {

    WorkFollowDetailInteractor(WorkFollowDetailContract.Presenter presenter) {
        super(presenter);
    }


    @Override
    public void getWorkFlowDetailData(String work_flow_id, CommonCallback<WorkFlowDetailDTO> commonCallback) {
        ServiceBuilder.getWorkFlowService().getWorkFlowDetailData(work_flow_id).enqueue(commonCallback);
    }
}
