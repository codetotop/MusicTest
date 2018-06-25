package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.LocationDTO;
import com.gem.mpi.model.LocationModel;

import java.util.ArrayList;
import java.util.List;

public class LocationMapper {
  public static LocationModel transform(LocationDTO dto) {
    if (dto == null)
      return null;
    LocationModel model = new LocationModel();
    model.setCode(dto.getCode());
    model.setName(dto.getName());
    model.setShifts(transformShiftModelList(dto.getShifts()));
    return model;
  }

  public static LocationModel.ShiftModel transformShiftModel(LocationDTO.ShiftDTO shiftDTO) {
    if (shiftDTO == null)
      return null;
    LocationModel.ShiftModel shiftModel = new LocationModel.ShiftModel();
    shiftModel.setId(shiftDTO.getId());
    shiftModel.setEnd(shiftDTO.getEnd());
    shiftModel.setLocationId(shiftDTO.getLocationId());
    shiftModel.setName(shiftDTO.getName());
    shiftModel.setSpansDays(shiftDTO.getSpansDays());
    return shiftModel;
  }
  public static List<LocationModel.ShiftModel> transformShiftModelList(List<LocationDTO.ShiftDTO> dtos){
    if (dtos==null)
      return null;
    List<LocationModel.ShiftModel> shiftModels= new ArrayList<>();
    for (LocationDTO.ShiftDTO dto: dtos){
      shiftModels.add(transformShiftModel(dto));
    }
    return shiftModels;
  }
}
