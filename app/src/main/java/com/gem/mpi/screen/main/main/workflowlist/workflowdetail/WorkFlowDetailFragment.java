package com.gem.mpi.screen.main.main.workflowlist.workflowdetail;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.workflowlist.workflowdetail.adapter.DocumentAdapter;
import com.gem.mpi.screen.main.main.workflowlist.workflowdetail.adapter.HandleFlowAdapter;
import com.gem.mpi.screen.main.main.workflowlist.workflowdetail.adapter.HandleIdeaAdapter;
import com.gem.mpi.screen.main.main.workflowlist.workflowdetail.model.HandleFlowModel;
import com.gem.mpi.screen.main.main.workflowlist.workflowdetail.model.HandleIdeaModel;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * The WorkFlow Fragment
 */
public class WorkFlowDetailFragment extends ViewFragment<WorkFlowDetailContract.Presenter> implements WorkFlowDetailContract.View {
  @BindView(R.id.workflow_rcv_documentrelation)
  RecyclerView mDocumentRelationRcv;
  @BindView(R.id.workflow_rcv_handleflow)
  RecyclerView mHandleFlowRcv;
  @BindView(R.id.workflow_rcv_handleidea)
  RecyclerView mHandleIdeaRcv;
  @BindView(R.id.workflow_btn_handleidea)
  Button mHandleIdeaBtn;
  @BindView(R.id.tbvToolbar)
  ToolbarView mToolbarTbv;

  DocumentAdapter documentAdapter;
  HandleFlowAdapter handleFlowAdapter;
  HandleIdeaAdapter handleIdeaAdapter;

  ArrayList<HandleFlowModel> handleFlowModels;
  ArrayList<HandleIdeaModel> handleIdeaModels;
  ArrayList<String> documents;


  public static WorkFlowDetailFragment getInstance() {
    return new WorkFlowDetailFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_work_flow_detail;
  }

  private void addView() {
    mDocumentRelationRcv.setLayoutManager(new LinearLayoutManager(getViewContext()));
    mHandleFlowRcv.setLayoutManager(new LinearLayoutManager(getViewContext()));
    mHandleIdeaRcv.setLayoutManager(new LinearLayoutManager(getViewContext()));

    documents = new ArrayList<>();
    //addDocumentFakeData();
    handleFlowModels = new ArrayList<>();
    //addHandleFlowFakeData();
    handleIdeaModels = new ArrayList<>();
    //addhandleIdeaFakeData();

    documentAdapter = new DocumentAdapter(getViewContext(), documents, false);
    handleFlowAdapter = new HandleFlowAdapter(getViewContext(), handleFlowModels);
    handleIdeaAdapter = new HandleIdeaAdapter(getViewContext(), handleIdeaModels);

    mDocumentRelationRcv.setAdapter(documentAdapter);
    mHandleFlowRcv.setAdapter(handleFlowAdapter);
    mHandleIdeaRcv.setAdapter(handleIdeaAdapter);

  }

  private void addDocumentFakeData() {
    documents.add("Danh sach can bo.dox");
    documents.add("Danh sach phong ban.dox");
    documents.add("Bao cao thang 5.dox");
  }

  private void addHandleFlowFakeData() {
    handleFlowModels.add(new HandleFlowModel("Nguyễn Huy Hùng", "Giám đốc", "Lãnh đạo đã giao việc", "20/5/2018"));
    handleFlowModels.add(new HandleFlowModel("Nguyễn Huy Hùng", "Giám đốc", "Lãnh đạo đã giao việc", "20/5/2018"));
    handleFlowModels.add(new HandleFlowModel("Nguyễn Huy Hùng", "Giám đốc", "Lãnh đạo đã giao việc", "20/5/2018"));
  }

  private void addhandleIdeaFakeData() {
    ArrayList<String> document1 = new ArrayList<>();
    document1.add("abc.docx");
    document1.add("xyz.docx");
    document1.add("123.docx");
    ArrayList<String> document2 = new ArrayList<>();
    document2.add("NguyenBaDung.docx");
    document2.add("PhungVanCong.docx");
    document2.add("VuHuuDuan.docx");
    ArrayList<String> document3 = new ArrayList<>();
    document3.add("NguyenTrongHoang.docx");
    document3.add("NguenVanQuy.docx");
    document3.add("PhamHuyAnh.docx");
    handleIdeaModels.add(new HandleIdeaModel("https://www.flaticon.com/free-icon/avatar_126486#term=person&page=1&position=2", "Nguyen Huy Nam", "20/5/2018", "Kính gửi vụ Quản lý quy hoạch,\n" +
        "Tôi xin gửi Quý vụ ý kiến CLPT ( A.Thắng đã ký) trong hồ sơ đính kèm.", "Nguyen Ba Dung", document1));
    handleIdeaModels.add(new HandleIdeaModel("https://www.flaticon.com/free-icon/avatar_126486#term=person&page=1&position=2", "Nguyen Huy Hung", "20/5/2018", "Kính gửi vụ Quản lý quy hoạch,\n" +
        "Tôi xin gửi Quý vụ ý kiến CLPT ( A.Thắng đã ký) trong hồ sơ đính kèm.", "Nguyen Ba Dung", document2));
    handleIdeaModels.add(new HandleIdeaModel("https://www.flaticon.com/free-icon/avatar_126486#term=person&page=1&position=2", "Nguyen Huy Anh", "20/5/2018", "Kính gửi vụ Quản lý quy hoạch,\n" +
        "Tôi xin gửi Quý vụ ý kiến CLPT ( A.Thắng đã ký) trong hồ sơ đính kèm.", "Nguyen Ba Dung", document3));
  }

  @OnClick(R.id.workflow_btn_handleidea)
  void clickBtnHandleIdea() {
    mPresenter.openHandleIdeaFragment();
  }


  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.IMAGE, R.string.title_detail_workflow,
        R.drawable.ic_back, null, R.drawable.ic_word, null,
        new ToolbarView.OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        }, new ToolbarView.OnActionRightListener() {
          @Override
          public void onActionRightClick() {
            getPresenter().handleActionRight();
          }
        }
    );
    addView();
  }

  @Override
  public void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId, Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId, ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener) {
    mToolbarTbv.init(actionLeftStyle, actionRightStyle, titleId,
        actionLeftDrawbleId, actionLeftStringId, actionRightDrawableId, actionRightStringId,
        onActionLeftListener, onActionRightListener);
  }
}
