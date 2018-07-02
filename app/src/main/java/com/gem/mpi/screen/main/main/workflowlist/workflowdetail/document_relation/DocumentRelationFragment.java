package com.gem.mpi.screen.main.main.workflowlist.workflowdetail.document_relation;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

/**
 * The DocumentRelation Fragment
 */
public class DocumentRelationFragment extends ViewFragment<DocumentRelationContract.Presenter> implements DocumentRelationContract.View {

  public static DocumentRelationFragment getInstance(Bundle data) {
    return new DocumentRelationFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_document_relation;
  }
}
