package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.adapter.DocumentAdapter;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.adapter.HandleFollowAdapter;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.adapter.HandleIdeaAdapter;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model.DocumentModel;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model.HandleFollowModel;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model.HandleIdeaModel;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * The workfollowdetail Fragment
 */
public class WorkFollowDetailFragment extends ViewFragment<WorkFollowDetailContract.Presenter> implements WorkFollowDetailContract.View {
  @BindView(R.id.workfollowdetail_rcv_documentrelation)
  RecyclerView mDocumentRelationRcv;
  @BindView(R.id.workfollowdetail_rcv_handlefollow)
  RecyclerView mHandleFlowRcv;
  @BindView(R.id.workfollowdetail_rcv_handleidea)
  RecyclerView mHandleIdeaRcv;
  @BindView(R.id.workfollowdetail_btn_handleidea)
  Button mHandleIdeaBtn;
  @BindView(R.id.tbvToolbar)
  ToolbarView mToolbarTbv;

  DocumentAdapter documentAdapter;
  HandleFollowAdapter handleFlowAdapter;
  HandleIdeaAdapter handleIdeaAdapter;

  ArrayList<HandleFollowModel> handleFollowModels;
  ArrayList<HandleIdeaModel> handleIdeaModels;
  ArrayList<DocumentModel> documentModels;


  public static WorkFollowDetailFragment getInstance(Bundle data) {
    WorkFollowDetailFragment fragment = new WorkFollowDetailFragment();
    fragment.setArguments(data);
    return fragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_work_follow_detail;
  }

  private void addView() {
    mDocumentRelationRcv.setLayoutManager(new LinearLayoutManager(getViewContext()));
    mHandleFlowRcv.setLayoutManager(new LinearLayoutManager(getViewContext()));
    mHandleIdeaRcv.setLayoutManager(new LinearLayoutManager(getViewContext()));

    documentModels = new ArrayList<>();
    addDocumentFakeData();
    handleFollowModels = new ArrayList<>();
    addHandleFlowFakeData();
    handleIdeaModels = new ArrayList<>();
    addhandleIdeaFakeData();

    documentAdapter = new DocumentAdapter(getViewContext(), documentModels);
    handleFlowAdapter = new HandleFollowAdapter(getViewContext(), handleFollowModels);
    handleIdeaAdapter = new HandleIdeaAdapter(getViewContext(), handleIdeaModels);

    mDocumentRelationRcv.setAdapter(documentAdapter);
    mHandleFlowRcv.setAdapter(handleFlowAdapter);
    mHandleIdeaRcv.setAdapter(handleIdeaAdapter);

  }

  private void addDocumentFakeData() {
    documentModels.add(new DocumentModel(R.drawable.ic_word,"Danh sach can bo.dox",R.drawable.ic_download));
    documentModels.add(new DocumentModel(R.drawable.ic_word,"Danh sach can bo.dox",R.drawable.ic_download));
    documentModels.add(new DocumentModel(R.drawable.ic_word,"Danh sach can bo.dox",R.drawable.ic_download));
  }

  private void addHandleFlowFakeData() {
    handleFollowModels.add(new HandleFollowModel("Nguyễn Huy Hùng", "Giám đốc", "Lãnh đạo đã giao việc", "20/5/2018"));
    handleFollowModels.add(new HandleFollowModel("Nguyễn Huy Hùng", "Giám đốc", "Lãnh đạo đã giao việc", "20/5/2018"));
    handleFollowModels.add(new HandleFollowModel("Nguyễn Huy Hùng", "Giám đốc", "Lãnh đạo đã giao việc", "20/5/2018"));
  }

  private void addhandleIdeaFakeData() {
    ArrayList<DocumentModel> document1 = new ArrayList<>();
    document1.add(new DocumentModel(R.drawable.ic_word,"abc.docx"));
    document1.add(new DocumentModel(R.drawable.ic_word,"xyz.docx"));
    document1.add(new DocumentModel(R.drawable.ic_word,"123.docx"));
    ArrayList<DocumentModel> document2 = new ArrayList<>();
    document2.add(new DocumentModel(R.drawable.ic_word,"NguyenBaDung.docx"));
    document2.add(new DocumentModel(R.drawable.ic_word,"PhungVanCong.docx"));
    document2.add(new DocumentModel(R.drawable.ic_word,"VuHuuDuan.docx"));
    ArrayList<DocumentModel> document3 = new ArrayList<>();
    document3.add(new DocumentModel(R.drawable.ic_word,"NguyenTrongHoang.docx"));
    document3.add(new DocumentModel(R.drawable.ic_word,"NguenVanQuy.docx"));
    document3.add(new DocumentModel(R.drawable.ic_word,"PhamHuyAnh.docx"));
    handleIdeaModels.add(new HandleIdeaModel("https://www.flaticon.com/free-icon/avatar_126486#term=person&page=1&position=2", "Nguyen Huy Nam", "20/5/2018", "Kính gửi vụ Quản lý quy hoạch,\n" +
        "Tôi xin gửi Quý vụ ý kiến CLPT ( A.Thắng đã ký) trong hồ sơ đính kèm.", "Nguyen Ba Dung", document1));
    handleIdeaModels.add(new HandleIdeaModel("https://www.flaticon.com/free-icon/avatar_126486#term=person&page=1&position=2", "Nguyen Huy Hung", "20/5/2018", "Kính gửi vụ Quản lý quy hoạch,\n" +
        "Tôi xin gửi Quý vụ ý kiến CLPT ( A.Thắng đã ký) trong hồ sơ đính kèm.", "Nguyen Ba Dung", document2));
    handleIdeaModels.add(new HandleIdeaModel("https://www.flaticon.com/free-icon/avatar_126486#term=person&page=1&position=2", "Nguyen Huy Anh", "20/5/2018", "Kính gửi vụ Quản lý quy hoạch,\n" +
        "Tôi xin gửi Quý vụ ý kiến CLPT ( A.Thắng đã ký) trong hồ sơ đính kèm.", "Nguyen Ba Dung", document3));
  }

  @OnClick(R.id.workfollowdetail_btn_handleidea)
  void clickBtnHandleIdea() {
    mPresenter.openHandleIdeaFragment();
  }


  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.IMAGE, R.string.title_detail__workfollowdetail,
        R.drawable.ic_back, null, R.drawable.ic_word, null,
        new ToolbarView.OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        }, new ToolbarView.OnActionRightListener() {
          @Override
          public void onActionRightClick() {
            getPresenter().handleActionRight(documentModels,handleIdeaModels);
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
