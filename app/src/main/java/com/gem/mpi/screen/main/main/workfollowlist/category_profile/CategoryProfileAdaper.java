package com.gem.mpi.screen.main.main.workfollowlist.category_profile;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gem.mpi.R;
import com.gem.mpi.model.CategoryProfileModel;

import java.util.List;

public class CategoryProfileAdaper extends BaseQuickAdapter<CategoryProfileModel, BaseViewHolder> {
  private int currentPositionCategoryProfile;

  public CategoryProfileAdaper(@Nullable List<CategoryProfileModel> data) {
    super(R.layout.item_category_profile, data);
    currentPositionCategoryProfile = 0;
  }

  @Override
  protected void convert(BaseViewHolder helper, CategoryProfileModel item) {
    if (currentPositionCategoryProfile != helper.getLayoutPosition()) {
      helper.setVisible(R.id.itemcategoryprofile_iv_profile_type_selected, false);
    } else {
      helper.setVisible(R.id.itemcategoryprofile_iv_profile_type_selected, true);
    }
    helper.setText(R.id.itemcategoryprofile_tv_profile_type, item.getName().concat(" (").concat(item.getCount()).concat(")"));

    switch (item.getKey()) {
      case "0":
      case "1":
      case "8":
      case "9":
      case "11":
        helper.setImageResource(R.id.itemcategoryprofile_iv_profile_type, R.drawable.ic_folder_yellow);
        break;
      case "2":
      case "3":
      case "4":
        helper.setImageResource(R.id.itemcategoryprofile_iv_profile_type, R.drawable.ic_warning_blue);
        break;
      case "5":
        helper.setImageResource(R.id.itemcategoryprofile_iv_profile_type, R.drawable.ic_warning_violet);
        break;
      case "6":
        helper.setImageResource(R.id.itemcategoryprofile_iv_profile_type, R.drawable.ic_warning_red);
        break;
      case "7":
        helper.setImageResource(R.id.itemcategoryprofile_iv_profile_type, R.drawable.ic_star_yellow);
        break;
      case "10":
        helper.setImageResource(R.id.itemcategoryprofile_iv_profile_type, R.drawable.ic_checked_green);
        break;

    }
  }

  public int getCurrentPositionCategoryProfile() {
    return currentPositionCategoryProfile;
  }

  public void setCurrentPositionCategoryProfile(int currentPositionCategoryProfile) {
    this.currentPositionCategoryProfile = currentPositionCategoryProfile;
  }
}
