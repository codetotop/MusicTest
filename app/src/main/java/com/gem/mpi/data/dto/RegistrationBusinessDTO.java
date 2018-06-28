package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegistrationBusinessDTO implements Serializable {
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("so_von_dang_ky")
  @Expose
  private String soVonDangKy;
  @SerializedName("so_doanh_nghiep_thanh_lap_moi")
  @Expose
  private String soDoanhNghiepThanhLapMoi;
  @SerializedName("so_lao_dong_dang_ky")
  @Expose
  private String soLaoDongDangKy;
  @SerializedName("so_doanh_nghiep_hoan_tat_thu_tuc_giai_the")
  @Expose
  private String soDoanhNghiepHoanTatThuTucGiaiThe;
  @SerializedName("so_doanh_nghiep_gap_kho_khan")
  @Expose
  private String soDoanhNghiepGapKhoKhan;
  @SerializedName("so_doanh_nghiep_gap_kho_khan_khong_dang_ky")
  @Expose
  private String soDoanhNghiepGapKhoKhanKhongDangKy;
  @SerializedName("so_doanh_nghiep_gap_kho_khan_co_dang_ky")
  @Expose
  private String soDoanhNghiepGapKhoKhanCoDangKy;
  @SerializedName("so_doanh_nghiep_tro_lai_hoat_dong")
  @Expose
  private String soDoanhNghiepTroLaiHoatDong;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSoVonDangKy() {
    return soVonDangKy;
  }

  public void setSoVonDangKy(String soVonDangKy) {
    this.soVonDangKy = soVonDangKy;
  }

  public String getSoDoanhNghiepThanhLapMoi() {
    return soDoanhNghiepThanhLapMoi;
  }

  public void setSoDoanhNghiepThanhLapMoi(String soDoanhNghiepThanhLapMoi) {
    this.soDoanhNghiepThanhLapMoi = soDoanhNghiepThanhLapMoi;
  }

  public String getSoLaoDongDangKy() {
    return soLaoDongDangKy;
  }

  public void setSoLaoDongDangKy(String soLaoDongDangKy) {
    this.soLaoDongDangKy = soLaoDongDangKy;
  }

  public String getSoDoanhNghiepHoanTatThuTucGiaiThe() {
    return soDoanhNghiepHoanTatThuTucGiaiThe;
  }

  public void setSoDoanhNghiepHoanTatThuTucGiaiThe(String soDoanhNghiepHoanTatThuTucGiaiThe) {
    this.soDoanhNghiepHoanTatThuTucGiaiThe = soDoanhNghiepHoanTatThuTucGiaiThe;
  }

  public String getSoDoanhNghiepGapKhoKhan() {
    return soDoanhNghiepGapKhoKhan;
  }

  public void setSoDoanhNghiepGapKhoKhan(String soDoanhNghiepGapKhoKhan) {
    this.soDoanhNghiepGapKhoKhan = soDoanhNghiepGapKhoKhan;
  }

  public String getSoDoanhNghiepGapKhoKhanKhongDangKy() {
    return soDoanhNghiepGapKhoKhanKhongDangKy;
  }

  public void setSoDoanhNghiepGapKhoKhanKhongDangKy(String soDoanhNghiepGapKhoKhanKhongDangKy) {
    this.soDoanhNghiepGapKhoKhanKhongDangKy = soDoanhNghiepGapKhoKhanKhongDangKy;
  }

  public String getSoDoanhNghiepGapKhoKhanCoDangKy() {
    return soDoanhNghiepGapKhoKhanCoDangKy;
  }

  public void setSoDoanhNghiepGapKhoKhanCoDangKy(String soDoanhNghiepGapKhoKhanCoDangKy) {
    this.soDoanhNghiepGapKhoKhanCoDangKy = soDoanhNghiepGapKhoKhanCoDangKy;
  }

  public String getSoDoanhNghiepTroLaiHoatDong() {
    return soDoanhNghiepTroLaiHoatDong;
  }

  public void setSoDoanhNghiepTroLaiHoatDong(String soDoanhNghiepTroLaiHoatDong) {
    this.soDoanhNghiepTroLaiHoatDong = soDoanhNghiepTroLaiHoatDong;
  }
}
