package com.example.lin.startproject327ljd.service;
import com.example.lin.startproject327ljd.bean.WeatherResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
/**
 * Created by lin on 2017/3/16.
 */

public interface Weather51Service {
    @GET ("data/sk/{cityCode}.html")
    Call<WeatherResult> getResult(@Path("cityCode")String cityCode);
}

