package com.gem.mpi.screen.main.main.workflowlist.workflowdetail.document_relation;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The DocumentRelation Presenter
 */
public class DocumentRelationPresenter extends Presenter<DocumentRelationContract.View, DocumentRelationContract.Interactor>
    implements DocumentRelationContract.Presenter {

  public DocumentRelationPresenter(ContainerView containerView) {
    super(containerView);
  }


  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public DocumentRelationContract.Interactor onCreateInteractor() {
    return new DocumentRelationInteractor(this);
  }

  @Override
  public DocumentRelationContract.View onCreateView(Bundle data) {
    return DocumentRelationFragment.getInstance(data);
  }
}
