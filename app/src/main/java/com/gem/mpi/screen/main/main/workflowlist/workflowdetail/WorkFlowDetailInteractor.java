package com.gem.mpi.screen.main.main.workflowlist.workflowdetail;

import com.gem.mpi.data.dto.WorkFlowDetailDTO;
import com.gem.mpi.data.remote.ServiceBuilder;
import com.gem.mpi.data.remote.callback.BaseCallback;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.Interactor;

/**
 * The WorkFlow interactor
 */
class WorkFlowDetailInteractor extends Interactor<WorkFlowDetailContract.Presenter>
        implements WorkFlowDetailContract.Interactor {

    WorkFlowDetailInteractor(WorkFlowDetailContract.Presenter presenter) {
        super(presenter);
    }


    @Override
    public void getWorkFlowDetailData(String work_flow_id, CommonCallback<WorkFlowDetailDTO> commonCallback) {
        ServiceBuilder.getWorkFlowService().getWorkFlowDetailData(work_flow_id).enqueue(commonCallback);
    }
}
