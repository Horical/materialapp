package com.horical.hrc7.materialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.horical.hrc7.lib_base.dialog.DialogPool;
import com.horical.hrc7.materialapp.test.component.HelloView;


public class MainActivity extends AppCompatActivity {
    HelloView helloView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloView = (HelloView) findViewById(R.id.helloView);
        helloView.bind("kkkkkkkkkkkkkkkkkkkkkkkkkkkk");
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
//        finish();
    }

}
