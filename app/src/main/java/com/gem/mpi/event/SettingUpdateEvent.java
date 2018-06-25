package com.gem.mpi.event;

/**
 * SettingUpdateEvent
 * Created by BaVV on 11/15/2017.
 */

public class SettingUpdateEvent {

  public enum Type {
    LOCATION, SURVEY
  }

  private Type mType;

  public SettingUpdateEvent(Type type) {
    mType = type;
  }

  public Type getType() {
    return mType;
  }
}
