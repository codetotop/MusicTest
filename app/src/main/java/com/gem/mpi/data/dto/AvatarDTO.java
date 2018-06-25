
package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvatarDTO {

  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("filename")
  @Expose
  private String filename;
  @SerializedName("extension")
  @Expose
  private String extension;
  @SerializedName("mimetype")
  @Expose
  private String mimetype;
  @SerializedName("path")
  @Expose
  private String path;
  @SerializedName("imageable_id")
  @Expose
  private int imageableId;
  @SerializedName("path_string")
  @Expose
  private String pathString;
  @SerializedName("media_type")
  @Expose
  private String mediaType;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getMimetype() {
    return mimetype;
  }

  public void setMimetype(String mimetype) {
    this.mimetype = mimetype;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public int getImageableId() {
    return imageableId;
  }

  public void setImageableId(int imageableId) {
    this.imageableId = imageableId;
  }

  public String getPathString() {
    return pathString;
  }

  public void setPathString(String pathString) {
    this.pathString = pathString;
  }

  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }
}
