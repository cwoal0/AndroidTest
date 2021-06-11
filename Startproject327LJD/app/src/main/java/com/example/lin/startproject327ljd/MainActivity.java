package com.example.lin.startproject327ljd;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lin.startproject327ljd.bean.WeatherInfo;
import com.example.lin.startproject327ljd.iface.WeatherListener;
import com.example.lin.startproject327ljd.model.WeatherModel;
import com.example.lin.startproject327ljd.model.Weather51Model;
public class MainActivity extends AppCompatActivity implements WeatherListener,View.OnClickListener{
    private EditText etcityno;
    private TextView tvcityname;
    private TextView tvcityno;
    private TextView temp;
    private TextView wd;
    private TextView ws;
    private TextView sd;
    private ProgressDialog loadingWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        etcityno = (EditText) findViewById(R.id.editText);
        Button btnfind1 = (Button) findViewById(R.id.button);
        Button btnfind2 = (Button) findViewById(R.id.button2);
        tvcityname = (TextView) findViewById(R.id.tv_city);
        tvcityno = (TextView) findViewById(R.id.tv_cityno);
        temp = (TextView) findViewById(R.id.tv_temp);
        wd = (TextView) findViewById(R.id.tv_WD);
        ws = (TextView) findViewById(R.id.tv_WS);
        sd = (TextView) findViewById(R.id.tv_SD);

        //实例化进度条
        loadingWeather = new ProgressDialog(this);
        loadingWeather.setTitle("查询中...");

        btnfind1.setOnClickListener(this);
        btnfind2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        loadingWeather.show();
        switch (v.getId()){
            case R.id.button:
                WeatherModel weatherModel=new WeatherModel();
                weatherModel.getWeather(etcityno.getText().toString(),this);
                break;
            case R.id.button2:
                Weather51Model weather51Model=new Weather51Model();
                weather51Model.getWeather(etcityno.getText().toString(),this);
                break;
            default:
                break;
        }
    }
    //获取数据成功
    @Override
    public void onResponse(WeatherInfo weatherInfo) {
        //取消数据加载进度条
        loadingWeather.dismiss();
        if(weatherInfo!=null)
        {
            tvcityname.setText(weatherInfo.getCity());
            tvcityno.setText(weatherInfo.getCityid());
            temp.setText(weatherInfo.getTemp());
            wd.setText(weatherInfo.getWD());
            ws.setText(weatherInfo.getWS());
            sd.setText(weatherInfo.getSD());
        }
        else
        {
            tvcityname.setText("未知");
        }
    }

    //获取数据失败
    @Override
    public void onFail(String msg) {
        loadingWeather.dismiss();
        tvcityname.setText(msg);
        /*Toast.makeText(this,"fail:"+msg, Toast.LENGTH_SHORT).show();*/
    }
}

