package com.gem.mpi.screen.main.main.documentdetailto;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

/**
 * The DocumentDetailTo Fragment
 */
public class DocumentDetailToFragment extends ViewFragment<DocumentDetailToContract.Presenter> implements DocumentDetailToContract.View {

  public static DocumentDetailToFragment getInstance() {
    return new DocumentDetailToFragment();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_document_detail_to;
  }
}
