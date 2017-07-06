package com.horical.hrc7.materialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.horical.hrc7.materialapp.login.component.TestFragment;

public class MainActivity extends AppCompatActivity implements TestFragment.Listener {
    TestFragment testFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testFragment = (TestFragment) getSupportFragmentManager().findFragmentById(R.id.frag);
        testFragment.setListener(this);
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
//        finish();


    }


//    @Override
//    public void onTextClicked() {
//        testFragment.bind("jshdfjhsjdf");
//    }
}
