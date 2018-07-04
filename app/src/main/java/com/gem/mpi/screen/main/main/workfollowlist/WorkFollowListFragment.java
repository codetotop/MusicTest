package com.gem.mpi.screen.main.main.workfollowlist;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * The workfollowlistList Fragment
 */
public class WorkFollowListFragment extends ViewFragment<WorkFollowListContract.Presenter> implements WorkFollowListContract.View, View.OnClickListener, WorkFollowListAdapter.OnItemClick {
  private ArrayList<WorkFollowListModel> workfollowlistModels;
  private WorkFollowListAdapter workFollowListAdapter;
  @BindView(R.id.workfollowlist_header_view_worklist)
  ConstraintLayout mHeaderViewWorkListConstrainLayout;
  @BindView(R.id.workfollowlist_tv_header)
  TextView mHeaderTv;
  @BindView(R.id.workfollowlist_rcv_worklist)
  RecyclerView mWorkListRcv;

  public static WorkFollowListFragment getInstance(Bundle data) {
    WorkFollowListFragment fragment = new WorkFollowListFragment();
    fragment.setArguments(data);
    return fragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_work_follow_list;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getViewContext());
    mWorkListRcv.setLayoutManager(layoutManager);
    workfollowlistModels = new ArrayList<>();
    addFakeData();
    workFollowListAdapter = new WorkFollowListAdapter(getViewContext(), workfollowlistModels,this);
    mWorkListRcv.setAdapter(workFollowListAdapter);

    mHeaderViewWorkListConstrainLayout.setOnClickListener(this);
  }

  private void addFakeData() {
    workfollowlistModels.add(new WorkFollowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));
    workfollowlistModels.add(new WorkFollowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "error"));
    workfollowlistModels.add(new WorkFollowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));
    workfollowlistModels.add(new WorkFollowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "error"));
    workfollowlistModels.add(new WorkFollowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));
    workfollowlistModels.add(new WorkFollowListModel("Báo cáo công việc và báo cáo TĐKT tuần của các phòng năm 2018", "0001/TTTH-TTRH", "Bùi Thị Tùng Linh - 18/05/2018 6:19 40PM", "31/12/2018", "warning"));

  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.workfollowlist_header_view_worklist:
        getPresenter().openCategoryProfile();
        break;
      default:
        break;
    }
  }

  @Override
  public void click(int position) {
    mPresenter.openDetailWorkFollow(position);
  }

}
