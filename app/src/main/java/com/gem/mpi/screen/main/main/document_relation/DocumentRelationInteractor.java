package com.gem.mpi.screen.main.main.document_relation;

import com.gemvietnam.base.viper.Interactor;

/**
 * The DocumentRelation interactor
 */
class DocumentRelationInteractor extends Interactor<DocumentRelationContract.Presenter>
    implements DocumentRelationContract.Interactor {

  DocumentRelationInteractor(DocumentRelationContract.Presenter presenter) {
    super(presenter);
  }
}
