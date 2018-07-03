package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model;

import java.io.Serializable;

public class DocumentModel implements Serializable {
  private Integer imgDocumentAvatar;
  private String documentName;
  private Integer imgDocumentDownload;

  public DocumentModel() {
  }

  public DocumentModel(Integer imgDocumentAvatar, String documentName, Integer imgDocumentDownload) {
    this.documentName = documentName;
    this.imgDocumentAvatar = imgDocumentAvatar;
    this.imgDocumentDownload = imgDocumentDownload;
  }

  public DocumentModel(Integer imgDocumentAvatar, String documentName) {
    this.documentName = documentName;
    this.imgDocumentAvatar = imgDocumentAvatar;
  }

  public DocumentModel(String documentName) {
    this.documentName = documentName;
  }

  public String getDocumentName() {
    return documentName;
  }

  public void setDocumentName(String documentName) {
    this.documentName = documentName;
  }

  public Integer getImgDocumentAvatar() {
    return imgDocumentAvatar;
  }

  public void setImgDocumentAvatar(Integer imgDocumentAvatar) {
    this.imgDocumentAvatar = imgDocumentAvatar;
  }

  public Integer getImgDocumentDownload() {
    return imgDocumentDownload;
  }

  public void setImgDocumentDownload(Integer imgDocumentDownload) {
    this.imgDocumentDownload = imgDocumentDownload;
  }
}
