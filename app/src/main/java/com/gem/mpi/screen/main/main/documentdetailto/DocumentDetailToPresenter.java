package com.gem.mpi.screen.main.main.documentdetailto;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The DocumentDetailTo Presenter
 */
public class DocumentDetailToPresenter extends Presenter<DocumentDetailToContract.View, DocumentDetailToContract.Interactor>
    implements DocumentDetailToContract.Presenter {

  public DocumentDetailToPresenter(ContainerView containerView) {
    super(containerView);
  }



  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public DocumentDetailToContract.Interactor onCreateInteractor() {
    return new DocumentDetailToInteractor(this);
  }

  @Override
  public DocumentDetailToContract.View onCreateView(Bundle data) {
    return null;
  }
}
