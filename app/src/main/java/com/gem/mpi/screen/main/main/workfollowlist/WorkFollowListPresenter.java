package com.gem.mpi.screen.main.main.workfollowlist;

import android.os.Bundle;

import com.gem.mpi.screen.main.main.workfollowlist.category_profile.CategoryProfilePresenter;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.WorkFollowDetailPresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The WorkFlowList Presenter
 */
public class WorkFollowListPresenter extends Presenter<WorkFollowListContract.View, WorkFollowListContract.Interactor> implements WorkFollowListContract.Presenter {

  public WorkFollowListPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public WorkFollowListContract.View onCreateView(Bundle data) {
    return WorkFollowListFragment.getInstance(data);
  }

  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public WorkFollowListContract.Interactor onCreateInteractor() {
    return new WorkFollowListInteractor(this);
  }

  @Override
  public void openDetailWorkFollow(int position) {
    WorkFollowDetailPresenter presenter = new WorkFollowDetailPresenter(mContainerView);
    presenter.pushView();
  }

  @Override
  public void openCategoryProfile() {
    CategoryProfilePresenter categoryProfilePresenter = new CategoryProfilePresenter(mContainerView);
    categoryProfilePresenter.pushView();
  }
}
