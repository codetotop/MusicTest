package com.gem.mpi.screen.main.main.workfollowlist;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

/**
 * The WorkFlowList Contract
 */
interface WorkFollowListContract {

    interface Interactor extends IInteractor<Presenter> {
    }

    interface View extends PresentView<Presenter> {

    }

    interface Presenter extends IPresenter<View, Interactor> {
        void openDetailWorkFollow(int position);

        void openCategoryProfile();
    }
}



