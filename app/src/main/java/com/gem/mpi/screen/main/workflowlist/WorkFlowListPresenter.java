package com.gem.mpi.screen.main.workflowlist;

import android.os.Bundle;

import com.gem.mpi.screen.main.category_profile.CategoryProfilePresenter;
import com.gem.mpi.screen.main.workflowdetail.WorkFlowDetailPresenter;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * The WorkFlowList Presenter
 */
public class WorkFlowListPresenter extends Presenter<WorkFlowListContract.View, WorkFlowListContract.Interactor> implements WorkFlowListContract.Presenter {

  public WorkFlowListPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public WorkFlowListContract.View onCreateView(Bundle data) {
    return WorkFlowListFragment.getInstance(data);
  }

  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public WorkFlowListContract.Interactor onCreateInteractor() {
    return new WorkFlowListInteractor(this);
  }

  @Override
  public void openDetailWorkFlow(int position) {
    WorkFlowDetailPresenter presenter = new WorkFlowDetailPresenter(mContainerView);
    presenter.pushView();
  }

  @Override
  public void openCategoryProfile() {
    CategoryProfilePresenter categoryProfilePresenter = new CategoryProfilePresenter(mContainerView);
    categoryProfilePresenter.pushView();
  }
}
