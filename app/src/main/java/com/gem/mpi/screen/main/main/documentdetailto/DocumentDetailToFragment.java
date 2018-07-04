package com.gem.mpi.screen.main.main.documentdetailto;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gem.mpi.widget.ToolbarView;
import com.gemvietnam.base.viper.ViewFragment;

import butterknife.BindView;

/**
 * The DocumentDetailTo Fragment
 */
public class DocumentDetailToFragment extends ViewFragment<DocumentDetailToContract.Presenter> implements DocumentDetailToContract.View {
  @BindView(R.id.documentdetailto_tbv)
  ToolbarView mDocumentDetailToTbv;

  public static DocumentDetailToFragment getInstance(Bundle data) {
    return new DocumentDetailToFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_document_detail_to;
  }

  @Override
  public void onDisplay() {
    super.onDisplay();
    initToolBar();
  }

  public void initToolBar() {
    mDocumentDetailToTbv.init(ToolbarView.ActionStyle.IMAGE, ToolbarView.ActionStyle.IMAGE, R.string.title_documentdetailto_fragment, R.drawable.ic_back,
        null, R.drawable.ic_word, null, new ToolbarView.OnActionLeftListener() {
          @Override
          public void onActionLeftClick() {
            getPresenter().handleActionLeft();
          }
        }, new ToolbarView.OnActionRightListener() {
          @Override
          public void onActionRightClick() {

          }
        });
  }
}
