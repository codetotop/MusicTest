package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.ListCategoryProfileDTO;
import com.gem.mpi.model.ListCategoryProfileModel;

public class ListCategoryProfileMapper {
  public static ListCategoryProfileModel transfer(ListCategoryProfileDTO dto) {
    if (dto != null) {
      ListCategoryProfileModel model = new ListCategoryProfileModel();
      model.setListCategoryProfile(CategoryProfileMapper.transferToModel(dto.getListCategoryProfile()));
      return model;
    }
    return null;
  }
}
