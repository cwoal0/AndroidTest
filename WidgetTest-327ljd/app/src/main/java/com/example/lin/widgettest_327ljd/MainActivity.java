package com.example.lin.widgettest_327ljd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv;
    private EditText et;
    private Button btn1,btn2;
    private ImageButton imbtn;
    private ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){//获取控件
        tv=(TextView)findViewById(R.id.textView);
        et=(EditText)findViewById(R.id.editText);
        btn1=(Button) findViewById(R.id.button);
        btn2=(Button) findViewById(R.id.button2);
        im=(ImageView)findViewById(R.id.imageView);
        imbtn=(ImageButton) findViewById(R.id.imageButton);
        //设置按钮监听器
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        imbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button://设置文本
                String str=et.getText().toString();
                tv.setText(str);
                break;
            case R.id.button2://设置图片
                im.setImageResource(R.drawable.b);
                break;
            case R.id.imageButton://图片按钮
                break;
        }

    }
}
