package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.ListForeignInvestmentDataDTO;
import com.gem.mpi.model.ListForeignInvestmentDataModel;

public class ListForeignInvestmentDataMapper {
  public static ListForeignInvestmentDataModel transfer(ListForeignInvestmentDataDTO dto) {
    if (dto != null) {
      ListForeignInvestmentDataModel model = new ListForeignInvestmentDataModel();
      model.setCompanyRegisterNn(ForeignInvestmentDataMapper.transferToModel(dto.getCompanyRegisterNn()));
      return model;
    }
    return null;
  }
}
