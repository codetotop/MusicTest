package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.ForeignInvestmentDataDTO;
import com.gem.mpi.model.ForeignInvestmentDataModel;

import java.util.ArrayList;
import java.util.List;

public class ForeignInvestmentDataMapper {
  public static ForeignInvestmentDataModel transfer(ForeignInvestmentDataDTO dto) {
    if (dto != null) {
      ForeignInvestmentDataModel model = new ForeignInvestmentDataModel();
      model.setTitle(dto.getTitle());
      model.setVonThucHien(dto.getVonThucHien());
      model.setVdkDangKyCapMoi(dto.getVdkDangKyCapMoi());
      model.setVdkDangKyTangThem(dto.getVdkDangKyTangThem());
      model.setVdkGopVonMuaCoPhan(dto.getVdkGopVonMuaCoPhan());
      model.setSdanCapMoi(dto.getSdanCapMoi());
      model.setSdanTangVon(dto.getSdanTangVon());
      model.setSdanGopVon(dto.getSdanGopVon());
      model.setXkXuatKhauCaDauTho(dto.getXkXuatKhauCaDauTho());
      model.setXkXuatKhauKhongDauTho(dto.getXkXuatKhauKhongDauTho());
      model.setNhapKhau(dto.getNhapKhau());
      return model;
    }
    return null;
  }

  public static List<ForeignInvestmentDataModel> transferToModel(List<ForeignInvestmentDataDTO> dtos) {
    if (dtos != null) {
      List<ForeignInvestmentDataModel> models = new ArrayList<>();
      for (ForeignInvestmentDataDTO dto : dtos) {
        ForeignInvestmentDataModel model = transfer(dto);
        if (model != null) {
          models.add(model);
        }
      }
      return models;
    }
    return null;
  }
}
