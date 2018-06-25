package com.gem.mpi.model;

import java.io.Serializable;
import java.util.List;

public class LocationModel implements Serializable {
  private int mId;
  private String mName;
  private String mCode;
  private List<ShiftModel> mShifts;

  public int getId() {
    return mId;
  }

  public String getName() {
    return mName;
  }

  public String getCode() {
    return mCode;
  }

  public List<ShiftModel> getShifts() {
    return mShifts;
  }




  public void setName(String mName) {
    this.mName = mName;
  }

  public void setCode(String mCode) {
    this.mCode = mCode;
  }


  public void setShifts(List<ShiftModel> mShifts) {
    this.mShifts = mShifts;
  }

  public static class ShiftModel implements Serializable {
    private int mId;
    private int mLocationId;
    private String mName;
    private String mStart;
    private String mEnd;
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
  }
}