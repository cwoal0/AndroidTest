package com.example.lin.startproject327ljd.iface;

import com.example.lin.startproject327ljd.bean.WeatherInfo;
/**
 * Created by lin on 2017/3/14.
 */

//统一网络数据获取结果（成功/失败），定义接口
public interface WeatherListener {
    void onResponse(WeatherInfo weatherInfo);//成功返回天气信息
    void onFail(String msg);//失败返回天气信息
}