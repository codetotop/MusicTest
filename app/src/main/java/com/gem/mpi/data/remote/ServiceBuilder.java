package com.gem.mpi.data.remote;

import com.gem.mpi.App;
import com.gem.mpi.BuildConfig;
import com.gem.mpi.data.remote.services.AuthenticationServices;
import com.gem.mpi.data.remote.services.CategoryProfileService;
import com.gem.mpi.data.remote.services.ForeignInvestmentDataService;
import com.gem.mpi.data.remote.services.RegistrationBusinessService;
import com.gem.mpi.data.remote.services.WorkFlowServices;
import com.gem.mpi.model.LoginModel;
import com.gem.mpi.pref.PrefWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Web services builder
 * Created by neo on 2/15/2016.
 */
public class ServiceBuilder {

  private static Retrofit getRetrofit(String endPoint) {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    if (BuildConfig.DEBUG) {
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }
    final OkHttpClient client = new OkHttpClient.Builder()
        .readTimeout(90, TimeUnit.SECONDS)
        .connectTimeout(90, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .addInterceptor(new Interceptor() {
          // UserModel agent default
          @Override
          public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();

            // Build request with headers
            Request.Builder builder = original.newBuilder()
//                .header("UserModel-Agent", System.getProperty("http.agent"))
                .header("Content-Type", "application/json")
                .method(original.method(), original.body());

            // Get token
            LoginModel loginModel = PrefWrapper.getLoginResponse(App.getInstance());
            if (loginModel != null && !loginModel.getActionToken().isEmpty()) {
              builder.header("access_token", loginModel.getActionToken());
            }

            return chain.proceed(builder.build());
          }
        })
        .build();

    GsonBuilder builder = new GsonBuilder()
        .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
          public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return new Date(json.getAsJsonPrimitive().getAsLong());
          }
        });

    Gson gSon = builder.setLenient().create();

    return new Retrofit.Builder()
        .baseUrl(endPoint)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gSon))
        .build();
  }

  private static String getBaseUrl() {
    return BuildConfig.BASE_URL;
  }

  public static AuthenticationServices getAuthenticationServices() {
    return getRetrofit(getBaseUrl()).create(AuthenticationServices.class);
  }

  public static RegistrationBusinessService getRegistrationBusinessService() {
    return getRetrofit(getBaseUrl()).create(RegistrationBusinessService.class);
  }

  public static ForeignInvestmentDataService getForeignInvestmentDataService() {
    return getRetrofit(getBaseUrl()).create(ForeignInvestmentDataService.class);
  }

  public static CategoryProfileService getCategoryProfileService() {
    return getRetrofit(getBaseUrl()).create(CategoryProfileService.class);
  }

  public static WorkFlowServices getWorkFlowService(){
    return getRetrofit(getBaseUrl()).create(WorkFlowServices.class);
  }
}
