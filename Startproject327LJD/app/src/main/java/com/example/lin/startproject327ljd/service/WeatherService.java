package com.example.lin.startproject327ljd.service;
import com.example.lin.startproject327ljd.bean.WeatherResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
/**
 * Created by lin on 2017/3/16.
 */

public interface WeatherService {
    @GET ("data/sk/{cityNumber}.html")
    Call<WeatherResult> getResult(@Path("cityNumber")String cityNumber);
}
