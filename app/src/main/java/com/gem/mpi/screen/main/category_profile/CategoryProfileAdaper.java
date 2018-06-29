package com.gem.mpi.screen.main.category_profile;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gem.mpi.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryProfileAdaper extends BaseQuickAdapter<CategoryProfileModel, BaseViewHolder> {
  private int currentPositionCategoryProfile;

  public CategoryProfileAdaper(@Nullable List<CategoryProfileModel> data) {
    super(R.layout.item_category_profile, data);
    currentPositionCategoryProfile = 0;
    List<CategoryProfileModel> listFake = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      listFake.add(new CategoryProfileModel());
    }
    setNewData(listFake);
  }

  @Override
  protected void convert(BaseViewHolder helper, CategoryProfileModel item) {
    if (currentPositionCategoryProfile != helper.getLayoutPosition()) {
      helper.setVisible(R.id.itemcategoryprofile_iv_profile_type_selected, false);
    } else {
      helper.setVisible(R.id.itemcategoryprofile_iv_profile_type_selected, true);
    }
  }

  public int getCurrentPositionCategoryProfile() {
    return currentPositionCategoryProfile;
  }

  public void setCurrentPositionCategoryProfile(int currentPositionCategoryProfile) {
    this.currentPositionCategoryProfile = currentPositionCategoryProfile;
  }
}
