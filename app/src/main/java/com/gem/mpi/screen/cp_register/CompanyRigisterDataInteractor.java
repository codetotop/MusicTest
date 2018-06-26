package com.gem.mpi.screen.cp_register;

import com.gemvietnam.base.viper.Interactor;

/**
 * The CompanyRigisterData interactor
 */
class CompanyRigisterDataInteractor extends Interactor<CompanyRigisterDataContract.Presenter>
        implements CompanyRigisterDataContract.Interactor {

    CompanyRigisterDataInteractor(CompanyRigisterDataContract.Presenter presenter) {
        super(presenter);
    }
}
