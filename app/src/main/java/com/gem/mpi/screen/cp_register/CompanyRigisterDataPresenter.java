package com.gem.mpi.screen.cp_register;

import android.os.Bundle;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The CompanyRigisterData Presenter
 */
public class CompanyRigisterDataPresenter extends Presenter<CompanyRigisterDataContract.View, CompanyRigisterDataContract.Interactor>
        implements CompanyRigisterDataContract.Presenter {

    public CompanyRigisterDataPresenter(ContainerView containerView) {
        super(containerView);
    }


    @Override
    public void start() {
        // Start getting data here
    }

    @Override
    public CompanyRigisterDataContract.Interactor onCreateInteractor() {
        return new CompanyRigisterDataInteractor(this);
    }

    @Override
    public CompanyRigisterDataContract.View onCreateView(Bundle data) {
        return CompanyRigisterDataFragment.getInstance(data);
    }
}
