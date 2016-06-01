package com.example.traburiss.autosms.pages.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.traburiss.autosms.R;

/**
 * @author traburiss
 * @date 2016/3/5
 * @info AutoSms
 * @desc 主类，设置新的自动信息和查阅过去发送的信息
 */
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
