package com.gem.mpi.screen.main.main.document_send_detail;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;

/**
 * The DocumentSendDetail Fragment
 */
public class DocumentSendDetailFragment extends ViewFragment<DocumentSendDetailContract.Presenter> implements DocumentSendDetailContract.View {
  @BindView(R.id.fragmentdocumentsenddetail_tbv_toolbar)
  ToolbarView mToolbarTbv;

  public static DocumentSendDetailFragment getInstance() {
    return new DocumentSendDetailFragment();
  }

  public static DocumentSendDetailFragment getInstance(Bundle data) {
    DocumentSendDetailFragment documentSendDetailFragment = new DocumentSendDetailFragment();
    documentSendDetailFragment.setArguments(data);
    return documentSendDetailFragment;
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_document_send_detail;
  }

  @Override
  public void initToolbar(ToolbarView.ActionStyle actionLeftStyle, ToolbarView.ActionStyle actionRightStyle, Integer titleId, Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId, ToolbarView.OnActionLeftListener onActionLeftListener, ToolbarView.OnActionRightListener onActionRightListener) {
    mToolbarTbv.init(actionLeftStyle, actionRightStyle, titleId,
        actionLeftDrawbleId, actionLeftStringId, actionRightDrawableId, actionRightStringId,
        onActionLeftListener, onActionRightListener);
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolbar(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.IMAGE, R.string.title_document_send_detail,
        R.drawable.ic_back, null, R.drawable.ic_word, null,
        new ToolbarView.OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        },
        new ToolbarView.OnActionRightListener() {
          @Override
          public void onActionRightClick() {
            getPresenter().handleActionRight();
          }
        }
    );
  }
}
