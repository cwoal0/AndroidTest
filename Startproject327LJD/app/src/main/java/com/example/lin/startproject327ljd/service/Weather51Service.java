package com.example.lin.startproject327ljd.service;
        import com.example.lin.startproject327ljd.bean.WeatherResult;
        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Query;
/**
 * Created by lin on 2017/3/16.
 */

public interface Weather51Service {
    @GET ("GetMoreWeather")
    Call<WeatherResult> getResult(@Query("cityCode") String cityCode,
                                  @Query("weatherType") int weatherType);
}