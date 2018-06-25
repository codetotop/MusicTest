package com.gem.mpi.screen.authentication.forgot;

import com.gemvietnam.base.viper.Interactor;

/**
 * The ForgotPassword interactor
 */
class ForgotPasswordInteractor extends Interactor<ForgotPasswordContract.Presenter>
        implements ForgotPasswordContract.Interactor {

    ForgotPasswordInteractor(ForgotPasswordContract.Presenter presenter) {
        super(presenter);
    }
}
