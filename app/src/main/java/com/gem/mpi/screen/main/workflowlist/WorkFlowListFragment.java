package com.gem.mpi.screen.main.workflowlist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * The WorkFlowList Fragment
 */
public class WorkFlowListFragment extends ViewFragment<WorkFlowListContract.Presenter> implements WorkFlowListContract.View {
    private ArrayList<WorkFlowListModel> workFlowModels;
    private WorkFlowListAdapter workFlowListAdapter;
    @BindView(R.id.tvHeader)
    TextView tvHeader;
    @BindView(R.id.rcvWorkList)
    RecyclerView rcvWorkList;

    public static WorkFlowListFragment getInstance(Bundle data) {
        return new WorkFlowListFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_flow_list;
    }

    @Override
    public void onDisplay() {
        super.onDisplay();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getViewContext());
        rcvWorkList.setLayoutManager(layoutManager);
        workFlowModels = new ArrayList<>();
        addFakeData();
        workFlowListAdapter = new WorkFlowListAdapter(getViewContext(), workFlowModels);
        rcvWorkList.setAdapter(workFlowListAdapter);
    }

    private void addFakeData() {
        workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));
        workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "error"));
        workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));
        workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "error"));
        workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));
        workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));

    }
}
