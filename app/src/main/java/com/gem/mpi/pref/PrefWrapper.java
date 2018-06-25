package com.gem.mpi.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.gem.mpi.data.dto.EmployeeDTO;
import com.gem.mpi.data.dto.LocationDTO;
import com.gem.mpi.data.dto.UserDTO;
import com.gem.mpi.util.FileUtils;
import com.gemvietnam.utils.StringUtils;
import com.google.gson.Gson;

import java.io.InputStream;

/**
 * Shared Preferences wrapper
 * Created by NEO on 11/8/2016.
 */

public class PrefWrapper {
  private static final String MY_PREFERENCES = "Pref";

  private static final String KEY_USER = "user";
  private static final String KEY_DEVICE_TOKEN_REGISTERED = "device_token_registered";

  private static final String KEY_LANGUAGE = "language";
  private static final String KEY_LOCATION = "location";

  private static SharedPreferences getPreference(Context context) {
    return context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
  }

  /**
   * Save UserModel as json
   */
  public static synchronized void saveUser(Context context, UserDTO user) {
    String userJson = new Gson().toJson(user);
    SharedPreferences.Editor editor = getPreference(context).edit();
    editor.putString(KEY_USER, userJson);
    editor.apply();
  }

  /**
   * Get UserModel from saved json
   */
  public static synchronized UserDTO getUser(Context context) {
    String userJson = getPreference(context).getString(KEY_USER, null);
    if (StringUtils.isEmpty(userJson)) {
      return null;
    }

    return new Gson().fromJson(userJson, UserDTO.class);
  }

  public static synchronized void clearUser(Context context) {
    SharedPreferences.Editor editor = getPreference(context).edit();
    editor.remove(KEY_USER);
    editor.apply();
  }


  public static void setDeviceTokenRegistered(Context context, boolean registered) {
    SharedPreferences.Editor editor = getPreference(context).edit();
    editor.putBoolean(KEY_DEVICE_TOKEN_REGISTERED, registered);
    editor.apply();
  }

  public static boolean isDeviceTokenRegistered(Context context) {
    return getPreference(context).getBoolean(KEY_DEVICE_TOKEN_REGISTERED, false);
  }

  /**
   * Save language
   */
  public static void saveLanguage(Context context, String language) {
    SharedPreferences.Editor editor = getPreference(context).edit();
    editor.putString(KEY_LANGUAGE, language);
    editor.apply();
  }

  /**
   * Get language
   */
  public static String getLanguage(Context context) {
    return getPreference(context).getString(KEY_LANGUAGE, null);
  }

  /**
   * Save Location setting as json
   */
  public static synchronized void saveLocationSetting(Context context, LocationDTO locationDTO) {
    String locationJson = new Gson().toJson(locationDTO);
    SharedPreferences.Editor editor = getPreference(context).edit();
    editor.putString(KEY_LOCATION, locationJson);
    editor.apply();
  }

  /**
   * Get Location setting from saved json
   */
  public static synchronized LocationDTO getLocationSetting(Context context) {
    String locationJson = getPreference(context).getString(KEY_LOCATION, null);
    if (StringUtils.isEmpty(locationJson)) {
      return null;
    }
    return new Gson().fromJson(locationJson, LocationDTO.class);
  }

  /**
   * Remove setting by {@code key}
   */
  public static void remove(Context context, String key) {
    getPreference(context).edit()
        .remove(key)
        .apply();
  }

  public static void clear(Context context) {
    SharedPreferences.Editor editor = getPreference(context).edit();
    editor.clear();
    editor.apply();
  }

  /* [BaVV] ADD FAKE JSON START */

  public static EmployeeDTO getFakeEmployee(Context context) {
    InputStream inputStream = null;
    String json = FileUtils.readAssetFile(context, "jsons/login-response.json");
    if (null == json) return null;
    EmployeeDTO employeeDTO = new Gson().fromJson(json, EmployeeDTO.class);

    return employeeDTO;
  }

  /* [BaVV] ADD FAKE JSON END */
}
