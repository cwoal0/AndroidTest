package com.example.lin.startproject327ljd.bean;

/**
 * Created by lin on 2017/3/14.
 */

public class WeatherInfo {
    private String city;
    private String temp;
    private String WD;
    private String WS;
    private String SD;
    private String WSE;
    private String time;
    private String njd;
    private String cityid;

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public String getWSE() {return WSE;}

    public void setWSE(String WSE) {this.WSE = WSE;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getNjd() {return njd;}

    public void setNjd(String njd) {this.njd = njd;}

}
//    private WeatherInfo weatherinfo;
//
//    public WeatherInfo getWeatherinfo() {
//        return weatherinfo;
//    }
//
//    public void setWeatherinfo(WeatherInfo weatherinfo) {
//        this.weatherinfo = weatherinfo;
//    }
//"isRadar":"1","Radar":"JC_RADAR_AZ9411_JB","njd":"10000","qy":"1002","rain":"0"}}