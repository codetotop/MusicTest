package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.documentrelation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.WorkFollowDetailFragment;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.adapter.DocumentAdapter;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model.DocumentModel;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;

/**
 * The DocumentRelation Fragment
 */
public class DocumentRelationFragment extends ViewFragment<DocumentRelationContract.Presenter> implements DocumentRelationContract.View {
  @BindView(R.id.tbvToolbar)
  ToolbarView mDocumentRelationTbv;
  @BindView(R.id.documentrelation_rcv)
  RecyclerView mDocumentRelationRcv;
  static ArrayList<DocumentModel> documents;
  DocumentAdapter documentAdapter;

  public static DocumentRelationFragment getInstance(Bundle data) {
    return new DocumentRelationFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_document_relation;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.NONE, R.string.title_documentrelation_workfollowdetail,
        R.drawable.ic_back, null, null, null,
        new ToolbarView.OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        }, null
    );

    addView();

  }

  private void addView() {
    mDocumentRelationRcv.setLayoutManager(new LinearLayoutManager(getViewContext()));
    documents = new ArrayList<>();
    Bundle bundle = getArguments();
    documents.addAll((Collection<? extends DocumentModel>) bundle.getSerializable("documents"));
//    documents.add(new DocumentModel(R.drawable.ic_word,"Danh sach can bo.dox",R.drawable.ic_download));
//    documents.add(new DocumentModel(R.drawable.ic_word,"Danh sach can bo.dox",R.drawable.ic_download));
//    documents.add(new DocumentModel(R.drawable.ic_word,"Danh sach can bo.dox"));
    documentAdapter = new DocumentAdapter(getViewContext(), documents);
    mDocumentRelationRcv.setAdapter(documentAdapter);
  }

  @Override
  public void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId, Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId, ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener) {
    mDocumentRelationTbv.init(actionLeftStyle, actionRightStyle, titleId,
        actionLeftDrawbleId, actionLeftStringId, actionRightDrawableId, actionRightStringId,
        onActionLeftListener, onActionRightListener);
  }
}
