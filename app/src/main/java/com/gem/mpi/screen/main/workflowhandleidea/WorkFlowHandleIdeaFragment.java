package com.gem.mpi.screen.main.workflowhandleidea;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.MainFragment;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * The WorkFlowHandleIdea Fragment
 */
public class WorkFlowHandleIdeaFragment extends ViewFragment<WorkFlowHandleIdeaContract.Presenter> implements WorkFlowHandleIdeaContract.View {
  @BindView(R.id.edtContentHandleIdea)
  EditText edtContentHandleIdea;
  public static WorkFlowHandleIdeaFragment getInstance(Bundle data) {
    return new WorkFlowHandleIdeaFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_work_flow_handle_idea;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();

    if (getParentFragment() != null && getParentFragment() instanceof MainFragment) {
      ((MainFragment) getParentFragment()).initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_handle_idea,
          R.drawable.ic_slide_menu, null, null, null, null, null
      );
    }

  }

  @OnClick(R.id.btnSendIdea) void onClickSendIdea(){
    // TODO handle send idea
  }
}
