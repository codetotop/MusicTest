package com.gem.mpi.screen.main.main.workflowlist.workflowdetail.workflowhandleidea;

import android.os.Bundle;
import android.widget.EditText;

import com.gem.mpi.R;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * The WorkFlowHandleIdea Fragment
 */
public class WorkFlowHandleIdeaFragment extends ViewFragment<WorkFlowHandleIdeaContract.Presenter> implements WorkFlowHandleIdeaContract.View {
  @BindView(R.id.tbvIdeaHandle)
  ToolbarView mIdeaHandleTbv;
  @BindView(R.id.workflowhandleidea_edt_content_handleidea)
  EditText mContentHandleIdeaEdt;
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
    initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_handleidea_workflowdetail,
        R.drawable.ic_cancel, null, null, null,
        new ToolbarView.OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        }, null
    );

  }

  @OnClick(R.id.workflowhandleidea_btn_sendidea) void onClickSendIdea(){
    mPresenter.sendIdea("1",mContentHandleIdeaEdt.getText().toString(),1);
  }

  @Override
  public void finishFragment() {
    if(getFragmentManager()!=null)
      getFragmentManager().popBackStack();
  }

  @Override
  public void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId, Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId, ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener) {
    mIdeaHandleTbv.init(actionLeftStyle,actionRightStyle,titleId,actionLeftDrawbleId,actionLeftStringId,actionRightDrawableId,actionRightStringId,onActionLeftListener,onActionRightListener);
  }
}
