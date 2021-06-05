package com.example.lin.startproject327ljd.iface;

/**
 * Created by lin on 2017/3/14.
 */

//统一不同方式获取天气，定义接口
public interface WeatherIface {
    void getWeather(String cityno,WeatherListener listener);
}
