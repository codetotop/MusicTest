package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.CategoryProfileDTO;
import com.gem.mpi.model.CategoryProfileModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryProfileMapper {
  public static CategoryProfileModel transfer(CategoryProfileDTO dto) {
    if (dto != null) {
      CategoryProfileModel model = new CategoryProfileModel();
      model.setName(dto.getName());
      model.setKey(dto.getKey());
      model.setCount(dto.getCount());
      return model;
    }
    return null;
  }

  public static List<CategoryProfileModel> transferToModel(List<CategoryProfileDTO> dtos) {
    if (dtos != null && !dtos.isEmpty()) {
      List<CategoryProfileModel> models = new ArrayList<>();
      for (CategoryProfileDTO dto : dtos) {
        CategoryProfileModel model = transfer(dto);
        if (model != null) {
          models.add(model);
        }
      }
      return models;
    }
    return null;
  }
}
