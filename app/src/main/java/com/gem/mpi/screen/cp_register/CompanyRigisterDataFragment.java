package com.gem.mpi.screen.cp_register;

import android.os.Bundle;

import com.gem.mpi.R;
import com.gemvietnam.base.viper.ViewFragment;

/**
 * The CompanyRigisterData Fragment
 */
public class CompanyRigisterDataFragment extends ViewFragment<CompanyRigisterDataContract.Presenter> implements CompanyRigisterDataContract.View {

    public static CompanyRigisterDataFragment getInstance(Bundle data) {
        return new CompanyRigisterDataFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_company_rigister_data;
    }
}
