package com.example.lin.startproject327ljd.model;
import com.example.lin.startproject327ljd.bean.WeatherResult;
import com.example.lin.startproject327ljd.iface.WeatherIface;
import com.example.lin.startproject327ljd.iface.WeatherListener;
import com.example.lin.startproject327ljd.service.Weather51Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc on 2017/3/14.
 */

public class Weather51Model implements WeatherIface {

    private Retrofit retrofit;
    private String BASEURL="http://weather.51wnl.com/weatherinfo/";
    public Weather51Model() {
        retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL)//主机地址
                .addConverterFactory(GsonConverterFactory.create())//解析方式
                .build();
    }

    @Override
    public void getWeather(String cityCode, final WeatherListener listener) {

        //retrifit接口使用3-2
        Weather51Service weather51Service=retrofit.create(Weather51Service.class);
        Call<WeatherResult> call=weather51Service.getMoreWeather(cityCode,1);
        //retrifit接口使用3-3
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if(response.isSuccessful()&& response.body()!=null)
                    listener.onResponse(response.body().getWeatherinfo());
                else
                    listener.onFail("onResponse error");
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
