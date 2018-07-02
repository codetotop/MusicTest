package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListRegistrationBusinessDTO {
  @SerializedName("company_register")
  @Expose
  List<RegistrationBusinessDTO> listRegistrationBusiness;

  public List<RegistrationBusinessDTO> getListRegistrationBusiness() {
    return listRegistrationBusiness;
  }

  public void setListRegistrationBusiness(List<RegistrationBusinessDTO> listRegistrationBusiness) {
    this.listRegistrationBusiness = listRegistrationBusiness;
  }
}
