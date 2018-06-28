package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListForeignInvestmentDataDTO {
  @SerializedName("company_register_nn")
  @Expose
  private List<ForeignInvestmentDataDTO> companyRegisterNn;

  public List<ForeignInvestmentDataDTO> getCompanyRegisterNn() {
    return companyRegisterNn;
  }

  public void setCompanyRegisterNn(List<ForeignInvestmentDataDTO> companyRegisterNn) {
    this.companyRegisterNn = companyRegisterNn;
  }
}
