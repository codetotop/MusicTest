
package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkingShiftDTO {

  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("description")
  @Expose
  private String description;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("official_start_time")
  @Expose
  private int officialStartTime;
  @SerializedName("official_end_time")
  @Expose
  private int officialEndTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getOfficialStartTime() {
    return officialStartTime;
  }

  public void setOfficialStartTime(int officialStartTime) {
    this.officialStartTime = officialStartTime;
  }

  public int getOfficialEndTime() {
    return officialEndTime;
  }

  public void setOfficialEndTime(int officialEndTime) {
    this.officialEndTime = officialEndTime;
  }
}
