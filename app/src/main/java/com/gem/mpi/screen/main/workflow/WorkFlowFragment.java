package com.gem.mpi.screen.main.workflow;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

/**
 * The WorkFlow Fragment
 */
public class WorkFlowFragment extends ViewFragment<WorkFlowContract.Presenter> implements WorkFlowContract.View {

    public static WorkFlowFragment getInstance() {
        return new WorkFlowFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_flow;
    }
}
