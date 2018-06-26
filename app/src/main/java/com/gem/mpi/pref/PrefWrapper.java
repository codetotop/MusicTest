package com.gem.mpi.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.gem.mpi.data.dto.LoginDTO;
import com.gem.mpi.mapper.LoginMapper;
import com.gem.mpi.model.LoginModel;
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
  private static final String KEY_LOGIN = "login";

  private static SharedPreferences getPreference(Context context) {
    return context.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
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

  public static void saveLoginResponse(Context context, LoginDTO loginDTO){
    String loginResponse = new Gson().toJson(loginDTO);
    SharedPreferences.Editor editor = (SharedPreferences.Editor) getPreference(context);
    editor.putString(KEY_LOGIN,loginResponse);
    editor.apply();
  }

  public static LoginModel getLoginResponse(Context context){
    String loginResponse = getPreference(context).getString(KEY_LOGIN,"");
    LoginDTO loginDTO = new Gson().fromJson(loginResponse,LoginDTO.class);
    return LoginMapper.transform(loginDTO);
  }
}
