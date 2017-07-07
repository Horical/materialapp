package com.horical.hrc7.libbasetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.horical.hrc7.libbasetest.hola.install.HolaActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CircleStrategy circleView = (CircleStrategy) findViewById(R.id.test1);
//        circleView.bind(270, 10);
        Intent intent = new Intent(this, HolaActivity.class);
        startActivity(intent);

    }

}
