package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.ListForeignInvestmentDataDTO;
import com.gem.mpi.model.ListForeignInvestmentDataModel;

public class ListForeignInvestmentDataMapper {
  public static ListForeignInvestmentDataModel transfer(ListForeignInvestmentDataDTO dto) {
    if (dto != null) {
      ListForeignInvestmentDataModel model = new ListForeignInvestmentDataModel();
      model.setListForeignInvestmentData(ForeignInvestmentDataMapper.transferToModel(dto.getListForeignInvestmentData()));
      return model;
    }
    return null;
  }
}
