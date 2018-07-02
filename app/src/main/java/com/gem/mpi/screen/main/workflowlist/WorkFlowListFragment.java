package com.gem.mpi.screen.main.workflowlist;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.MainFragment;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * The WorkFlowList Fragment
 */
public class WorkFlowListFragment extends ViewFragment<WorkFlowListContract.Presenter> implements WorkFlowListContract.View, View.OnClickListener, WorkFlowListAdapter.OnItemClick {
  private ArrayList<WorkFlowListModel> workFlowModels;
  private WorkFlowListAdapter workFlowListAdapter;
  @BindView(R.id.workflowlist_header_view_worklist)
  ConstraintLayout mHeaderViewWorkListConstrainLayout;
  @BindView(R.id.workflowlist_tv_header)
  TextView mHeaderTv;
  @BindView(R.id.workflowlist_rcv_worklist)
  RecyclerView mWorkListRcv;

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
    if (getParentFragment() != null && getParentFragment() instanceof MainFragment) {
      ((MainFragment) getParentFragment()).initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_list_workflow,
          R.drawable.ic_slide_menu, null, null, null, null, null
      );
    }
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getViewContext());
    mWorkListRcv.setLayoutManager(layoutManager);
    workFlowModels = new ArrayList<>();
    addFakeData();
    workFlowListAdapter = new WorkFlowListAdapter(getViewContext(), workFlowModels,this);
    mWorkListRcv.setAdapter(workFlowListAdapter);

    mHeaderViewWorkListConstrainLayout.setOnClickListener(this);
  }

  private void addFakeData() {
    workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));
    workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "error"));
    workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));
    workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "error"));
    workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));
    workFlowModels.add(new WorkFlowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));

  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.workflowlist_header_view_worklist:
        break;
      default:
        break;
    }
  }

  @Override
  public void click(int position) {
     mPresenter.openDetailWorkFlow(position);
  }

  @Override
  public void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId, Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId, ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener) {
    if (getParentFragment() != null && getParentFragment() instanceof MainFragment) {
      ((MainFragment) getParentFragment()).initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, titleId,
          actionLeftDrawbleId, null, null, null, null, null
      );
    }
  }
}
