package com.gem.mpi.screen.main.workflow;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.MainFragment;
import com.gem.mpi.screen.main.workflow.adapter.DocumentAdapter;
import com.gem.mpi.screen.main.workflow.adapter.HandleFlowAdapter;
import com.gem.mpi.screen.main.workflow.adapter.HandleIdeaAdapter;
import com.gem.mpi.screen.main.workflow.model.HandleFlowModel;
import com.gem.mpi.screen.main.workflow.model.HandleIdeaModel;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import org.w3c.dom.Document;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * The WorkFlow Fragment
 */
public class WorkFlowFragment extends ViewFragment<WorkFlowContract.Presenter> implements WorkFlowContract.View {
  @BindView(R.id.rcvDocumentRelation)
  RecyclerView rcvDocumentRelation;
  @BindView(R.id.rcvHandleFlow)
  RecyclerView rcvHandleFlow;
  @BindView(R.id.rcvHandleIdea)
  RecyclerView rcvHandleIdea;

  DocumentAdapter documentAdapter;
  HandleFlowAdapter handleFlowAdapter;
  HandleIdeaAdapter handleIdeaAdapter;

  ArrayList<HandleFlowModel> handleFlowModels;
  ArrayList<HandleIdeaModel> handleIdeaModels;
  ArrayList<String> documents;


  public static WorkFlowFragment getInstance() {
    return new WorkFlowFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_work_flow;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    if (getParentFragment() != null && getParentFragment() instanceof MainFragment) {
      ((MainFragment) getParentFragment()).initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_detail_workflow,
          R.drawable.ic_slide_menu, null, null, null, null, null
      );
    }
    addView();
  }

  private void addView() {
    rcvDocumentRelation.setLayoutManager(new LinearLayoutManager(getViewContext()));
    rcvHandleFlow.setLayoutManager(new LinearLayoutManager(getViewContext()));
    rcvHandleIdea.setLayoutManager(new LinearLayoutManager(getViewContext()));

    documents = new ArrayList<>();
    addDocumentFakeData();
    handleFlowModels = new ArrayList<>();
    addHandleFlowFakeData();
    handleIdeaModels = new ArrayList<>();
    addhandleIdeaFakeData();

    documentAdapter = new DocumentAdapter(getViewContext(), documents);
    handleFlowAdapter = new HandleFlowAdapter(getViewContext(), handleFlowModels);
    handleIdeaAdapter = new HandleIdeaAdapter(getViewContext(), handleIdeaModels);

    rcvDocumentRelation.setAdapter(documentAdapter);
    rcvHandleFlow.setAdapter(handleFlowAdapter);
    rcvHandleIdea.setAdapter(handleIdeaAdapter);
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
    handleIdeaModels.add(new HandleIdeaModel("https://www.flaticon.com/free-icon/avatar_126486#term=person&page=1&position=2", "Nguyen Huy Anh", "20/5/2018", "Kính gửi vụ Quản lý quy hoạch,\n" +
        "Tôi xin gửi Quý vụ ý kiến CLPT ( A.Thắng đã ký) trong hồ sơ đính kèm.", "Nguyen Ba Dung", "Danh sach.docx"));
    handleIdeaModels.add(new HandleIdeaModel("https://www.flaticon.com/free-icon/avatar_126486#term=person&page=1&position=2", "Nguyen Huy Anh", "20/5/2018", "Kính gửi vụ Quản lý quy hoạch,\n" +
        "Tôi xin gửi Quý vụ ý kiến CLPT ( A.Thắng đã ký) trong hồ sơ đính kèm.", "Nguyen Ba Dung", "Danh sach.docx"));
    handleIdeaModels.add(new HandleIdeaModel("https://www.flaticon.com/free-icon/avatar_126486#term=person&page=1&position=2", "Nguyen Huy Anh", "20/5/2018", "Kính gửi vụ Quản lý quy hoạch,\n" +
        "Tôi xin gửi Quý vụ ý kiến CLPT ( A.Thắng đã ký) trong hồ sơ đính kèm.", "Nguyen Ba Dung", "Danh sach.docx"));
  }


}
