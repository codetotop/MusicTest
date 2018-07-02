package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListForeignInvestmentDataDTO {
  @SerializedName("company_register_nn")
  @Expose
  private List<ForeignInvestmentDataDTO> listForeignInvestmentData;

  public List<ForeignInvestmentDataDTO> getListForeignInvestmentData() {
    return listForeignInvestmentData;
  }

  public void setListForeignInvestmentData(List<ForeignInvestmentDataDTO> listForeignInvestmentData) {
    this.listForeignInvestmentData = listForeignInvestmentData;
  }
}
