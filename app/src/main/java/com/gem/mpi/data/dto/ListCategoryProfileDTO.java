package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCategoryProfileDTO {
  @SerializedName("WorkfollowTemplate")
  @Expose
  private List<CategoryProfileDTO> listCategoryProfile;

  public List<CategoryProfileDTO> getListCategoryProfile() {
    return listCategoryProfile;
  }

  public void setListCategoryProfile(List<CategoryProfileDTO> listCategoryProfile) {
    this.listCategoryProfile = listCategoryProfile;
  }
}
