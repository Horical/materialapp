package com.horical.hrc7.libbasetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.horical.hrc7.lib_base.recycle_view.MyAdapter;
import com.horical.hrc7.libbasetest.hola.TempFragment;
import com.horical.hrc7.libbasetest.hola.install.HolaActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CircleStrategy circleView = (CircleStrategy) findViewById(R.id.test1);
//        circleView.bind(270, 10);
        TempFragment tempFragment= new TempFragment();// (TempFragment)getSupportFragmentManager().findFragmentById(R.id.frag);
        tempFragment.bind(new TempFragment.Item() {
            @Override
            public String getTitle() {
                return " abcdef12345";
            }
        });
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag,tempFragment)
                .commit();
        MyAdapter myAdapter = null;

    }

}
