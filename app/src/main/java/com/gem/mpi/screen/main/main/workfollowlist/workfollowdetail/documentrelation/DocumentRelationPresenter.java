package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.documentrelation;

import android.os.Bundle;

import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model.DocumentModel;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

import java.util.ArrayList;

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

  @Override
  public void handleActionLeft() {
    getFragment().getFragmentManager().popBackStack();
  }
}
