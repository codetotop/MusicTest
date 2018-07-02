package com.gem.mpi.model;

public class CommentModel {

  private String idYKien;
  private String noiDung;
  private String tenNguoiGopY;
  private String avatarNguoiGopY;
  private String idNguoiGopY;
  private String thoiGian;
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

  @Override
  public String toString() {
    return "CommentModel{" +
        "idYKien='" + idYKien + '\'' +
        ", noiDung='" + noiDung + '\'' +
        ", tenNguoiGopY='" + tenNguoiGopY + '\'' +
        ", avatarNguoiGopY='" + avatarNguoiGopY + '\'' +
        ", idNguoiGopY='" + idNguoiGopY + '\'' +
        ", thoiGian='" + thoiGian + '\'' +
        ", documentsAttact=" + documentsAttact +
        '}';
  }
}
