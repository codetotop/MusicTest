package com.gem.mpi.screen.main.main.document_send_detail;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The DocumentSendDetail Presenter
 */
public class DocumentSendDetailPresenter extends Presenter<DocumentSendDetailContract.View, DocumentSendDetailContract.Interactor> implements DocumentSendDetailContract.Presenter {

  public DocumentSendDetailPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public DocumentSendDetailContract.Interactor onCreateInteractor() {
    return new DocumentSendDetailInteractor(this);
  }

  @Override
  public DocumentSendDetailContract.View onCreateView(Bundle data) {
    return DocumentSendDetailFragment.getInstance(data);
  }

  @Override
  public void handleActionLeft() {

  }

  @Override
  public void handleActionRight() {

  }
}
