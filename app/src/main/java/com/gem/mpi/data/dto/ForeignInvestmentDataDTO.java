package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForeignInvestmentDataDTO {
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("von_thuc_hien")
  @Expose
  private String vonThucHien;
  @SerializedName("vdk_dang_ky_cap_moi")
  @Expose
  private String vdkDangKyCapMoi;
  @SerializedName("vdk_dang_ky_tang_them")
  @Expose
  private String vdkDangKyTangThem;
  @SerializedName("vdk_gop_von_mua_co_phan")
  @Expose
  private String vdkGopVonMuaCoPhan;
  @SerializedName("sdan_cap_moi")
  @Expose
  private String sdanCapMoi;
  @SerializedName("sdan_tang_von")
  @Expose
  private String sdanTangVon;
  @SerializedName("sdan_gop_von")
  @Expose
  private String sdanGopVon;
  @SerializedName("xk_xuat_khau_ca_dau_tho")
  @Expose
  private String xkXuatKhauCaDauTho;
  @SerializedName("xk_xuat_khau_khong_dau_tho")
  @Expose
  private String xkXuatKhauKhongDauTho;
  @SerializedName("nhap_khau")
  @Expose
  private String nhapKhau;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getVonThucHien() {
    return vonThucHien;
  }

  public void setVonThucHien(String vonThucHien) {
    this.vonThucHien = vonThucHien;
  }

  public String getVdkDangKyCapMoi() {
    return vdkDangKyCapMoi;
  }

  public void setVdkDangKyCapMoi(String vdkDangKyCapMoi) {
    this.vdkDangKyCapMoi = vdkDangKyCapMoi;
  }

  public String getVdkDangKyTangThem() {
    return vdkDangKyTangThem;
  }

  public void setVdkDangKyTangThem(String vdkDangKyTangThem) {
    this.vdkDangKyTangThem = vdkDangKyTangThem;
  }

  public String getVdkGopVonMuaCoPhan() {
    return vdkGopVonMuaCoPhan;
  }

  public void setVdkGopVonMuaCoPhan(String vdkGopVonMuaCoPhan) {
    this.vdkGopVonMuaCoPhan = vdkGopVonMuaCoPhan;
  }

  public String getSdanCapMoi() {
    return sdanCapMoi;
  }

  public void setSdanCapMoi(String sdanCapMoi) {
    this.sdanCapMoi = sdanCapMoi;
  }

  public String getSdanTangVon() {
    return sdanTangVon;
  }

  public void setSdanTangVon(String sdanTangVon) {
    this.sdanTangVon = sdanTangVon;
  }

  public String getSdanGopVon() {
    return sdanGopVon;
  }

  public void setSdanGopVon(String sdanGopVon) {
    this.sdanGopVon = sdanGopVon;
  }

  public String getXkXuatKhauCaDauTho() {
    return xkXuatKhauCaDauTho;
  }

  public void setXkXuatKhauCaDauTho(String xkXuatKhauCaDauTho) {
    this.xkXuatKhauCaDauTho = xkXuatKhauCaDauTho;
  }

  public String getXkXuatKhauKhongDauTho() {
    return xkXuatKhauKhongDauTho;
  }

  public void setXkXuatKhauKhongDauTho(String xkXuatKhauKhongDauTho) {
    this.xkXuatKhauKhongDauTho = xkXuatKhauKhongDauTho;
  }

  public String getNhapKhau() {
    return nhapKhau;
  }

  public void setNhapKhau(String nhapKhau) {
    this.nhapKhau = nhapKhau;
  }

}
