package com.example.lin.startproject327ljd.model;
import com.example.lin.startproject327ljd.iface.WeatherListener;
import com.example.lin.startproject327ljd.iface.WeatherIface;
import com.example.lin.startproject327ljd.bean.WeatherResult;
import com.example.lin.startproject327ljd.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lin on 2017/3/14.
 */

public class WeatherModel implements WeatherIface{
    private WeatherService service;
    private Retrofit retrofit;
    private static final String BASEURL = "http://www.weather.com.cn/";

    public WeatherModel() {
        //REtrofit实例化,接口使用3--1
        retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL)//主机地址
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

   @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        //Retrofit接口使用3—2
       WeatherService weatherService=
               retrofit.create(WeatherService.class);
       Call<WeatherResult> call=
               weatherService.getResult(cityno);
       //Retrofit接口使用3--3
       call.enqueue(new Callback<WeatherResult>() {
           public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
               if(response.isSuccessful()&&response.body()!=null)
                   listener.onResponse(response.body().getWeatherinfo());
               else
                   listener.onFail("onResponse error");
           }
           public void onFailure(Call<WeatherResult> call, Throwable t) {
               //调用监听事件接口的onFail方法
                   listener.onFail(t.toString());
           }
       });
   }
}