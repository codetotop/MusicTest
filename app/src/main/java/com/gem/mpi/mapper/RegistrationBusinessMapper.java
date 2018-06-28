package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.RegistrationBusinessDTO;
import com.gem.mpi.model.RegistrationBusinessModel;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBusinessMapper {
  public static RegistrationBusinessModel transfer(RegistrationBusinessDTO dto) {
    if (dto != null) {
      RegistrationBusinessModel model = new RegistrationBusinessModel();
      model.setTitle(dto.getTitle());
      model.setSoVonDangKy(dto.getSoVonDangKy());
      model.setSoDoanhNghiepThanhLapMoi(dto.getSoDoanhNghiepThanhLapMoi());
      model.setSoLaoDongDangKy(dto.getSoLaoDongDangKy());
      model.setSoDoanhNghiepHoanTatThuTucGiaiThe(dto.getSoDoanhNghiepHoanTatThuTucGiaiThe());
      model.setSoDoanhNghiepGapKhoKhan(dto.getSoDoanhNghiepGapKhoKhan());
      model.setSoDoanhNghiepGapKhoKhanKhongDangKy(dto.getSoDoanhNghiepGapKhoKhanKhongDangKy());
      model.setSoDoanhNghiepGapKhoKhanCoDangKy(dto.getSoDoanhNghiepGapKhoKhanCoDangKy());
      model.setSoDoanhNghiepTroLaiHoatDong(dto.getSoDoanhNghiepTroLaiHoatDong());
      return model;
    }
    return null;
  }

  public static List<RegistrationBusinessModel> transferToModel(List<RegistrationBusinessDTO> dtos) {
    if (dtos != null) {
      List<RegistrationBusinessModel> models = new ArrayList<>();
      for (RegistrationBusinessDTO dto : dtos) {
        RegistrationBusinessModel model = transfer(dto);
        if (model != null) {
          models.add(model);
        }
      }
      return models;
    }
    return null;
  }
}
