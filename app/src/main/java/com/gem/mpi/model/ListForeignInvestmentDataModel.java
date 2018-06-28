package com.gem.mpi.model;

import com.gem.mpi.data.dto.ForeignInvestmentDataDTO;

import java.util.List;

public class ListForeignInvestmentDataModel {
  private List<ForeignInvestmentDataModel> companyRegisterNn;

  public List<ForeignInvestmentDataModel> getCompanyRegisterNn() {
    return companyRegisterNn;
  }

  public void setCompanyRegisterNn(List<ForeignInvestmentDataModel> companyRegisterNn) {
    this.companyRegisterNn = companyRegisterNn;
  }
}
