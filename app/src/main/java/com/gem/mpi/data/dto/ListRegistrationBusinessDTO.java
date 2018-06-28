package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListRegistrationBusinessDTO {
  @SerializedName("company_register")
  @Expose
  List<RegistrationBusinessDTO> companyRegister;

  public List<RegistrationBusinessDTO> getCompanyRegister() {
    return companyRegister;
  }

  public void setCompanyRegister(List<RegistrationBusinessDTO> companyRegister) {
    this.companyRegister = companyRegister;
  }
}
