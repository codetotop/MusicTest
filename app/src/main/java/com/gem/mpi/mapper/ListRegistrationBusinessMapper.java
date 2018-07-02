package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.ListRegistrationBusinessDTO;
import com.gem.mpi.model.ListRegistrationBusinessModel;

public class ListRegistrationBusinessMapper {
  public static ListRegistrationBusinessModel transfer(ListRegistrationBusinessDTO dto) {
    if (dto != null) {
      ListRegistrationBusinessModel model = new ListRegistrationBusinessModel();
      model.setListRegistrationBusiness(RegistrationBusinessMapper.transferToModel(dto.getListRegistrationBusiness()));
    }
    return null;
  }
}
