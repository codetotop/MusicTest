package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CommentDTO implements Serializable {

  @SerializedName("id_y_kien")
  @Expose
  private String idYKien;
  @SerializedName("noi_dung")
  @Expose
  private String noiDung;
  @SerializedName("ten_nguoi_gop_y")
  @Expose
  private String tenNguoiGopY;
  @SerializedName("avatar_nguoi_gop_y")
  @Expose
  private String avatarNguoiGopY;
  @SerializedName("id_nguoi_gop_y")
  @Expose
  private String idNguoiGopY;
  @SerializedName("thoi_gian")
  @Expose
  private String thoiGian;
  @SerializedName("documents_attact")
  @Expose
  private Object documentsAttact;

  public String getIdYKien() {
    return idYKien;
  }

  public void setIdYKien(String idYKien) {
    this.idYKien = idYKien;
  }

  public String getNoiDung() {
    return noiDung;
  }

  public void setNoiDung(String noiDung) {
    this.noiDung = noiDung;
  }

  public String getTenNguoiGopY() {
    return tenNguoiGopY;
  }

  public void setTenNguoiGopY(String tenNguoiGopY) {
    this.tenNguoiGopY = tenNguoiGopY;
  }

  public String getAvatarNguoiGopY() {
    return avatarNguoiGopY;
  }

  public void setAvatarNguoiGopY(String avatarNguoiGopY) {
    this.avatarNguoiGopY = avatarNguoiGopY;
  }

  public String getIdNguoiGopY() {
    return idNguoiGopY;
  }

  public void setIdNguoiGopY(String idNguoiGopY) {
    this.idNguoiGopY = idNguoiGopY;
  }

  public String getThoiGian() {
    return thoiGian;
  }

  public void setThoiGian(String thoiGian) {
    this.thoiGian = thoiGian;
  }

  public Object getDocumentsAttact() {
    return documentsAttact;
  }

  public void setDocumentsAttact(Object documentsAttact) {
    this.documentsAttact = documentsAttact;
  }
}
