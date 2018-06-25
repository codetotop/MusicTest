package com.gem.mpi.data.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by BaVV on 03/21/2018.
 * LocationDTO
 */
public class LocationDTO implements Serializable {

  @SerializedName("locationId")
  private int mId;

  @SerializedName("locationName")
  private String mName;

  @SerializedName("locationCode")
  private String mCode;

  @SerializedName("locationShifts")
  private List<ShiftDTO> mShifts;

  public int getId() {
    return mId;
  }

  public String getName() {
    return mName;
  }

  public String getCode() {
    return mCode;
  }

  public List<ShiftDTO> getShifts() {
    return mShifts;
  }

  public static class ShiftDTO implements Serializable {

    @SerializedName("id")
    private int mId;

    @SerializedName("locationId")
    private int mLocationId;

    @SerializedName("name")
    private String mName;

    @SerializedName("start")
    private String mStart;

    @SerializedName("end")
    private String mEnd;

    @SerializedName("spansDays")
    private Boolean mSpansDays;

    public int getId() {
      return mId;
    }

    public String getName() {
      return mName;
    }


    public void setId(int mId) {
      this.mId = mId;
    }


    public void setLocationId(int mLocationId) {
      this.mLocationId = mLocationId;
    }


    public void setName(String mName) {
      this.mName = mName;
    }

    public String getStart() {
      return mStart;
    }

    public void setStart(String mStart) {
      this.mStart = mStart;
    }

    public String getEnd() {
      return mEnd;
    }

    public void setEnd(String mEnd) {
      this.mEnd = mEnd;
    }

    public Boolean getSpansDays() {
      return mSpansDays;
    }

    public void setSpansDays(Boolean mSpansDays) {
      this.mSpansDays = mSpansDays;
    }

    public int getLocationId() {
      return mLocationId;
    }


  }
}
