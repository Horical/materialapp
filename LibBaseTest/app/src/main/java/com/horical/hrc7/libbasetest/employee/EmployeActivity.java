package com.horical.hrc7.libbasetest.employee;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.horical.hrc7.lib_base.base.BaseActivity;
import com.horical.hrc7.lib_base.base.anotation.MyHandler;
import com.horical.hrc7.lib_base.base.anotation.MyServe;

import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.libbasetest.employee.install.EmployeHandler;
import com.horical.hrc7.libbasetest.employee.install.EmployeServe;
import com.horical.hrc7.libbasetest.R;

@MyHandler(EmployeHandler.class)
@MyServe(EmployeServe.class)
public class EmployeActivity extends BaseActivity<IEmployeView.Handler> implements IEmployeView, View.OnClickListener {
    @ViewChild(R.id.click)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe);
    }

    @Override
    protected void setupView() {
        btn.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                    Manifest.permission.CAMERA
            }, 1);
        }
    }

    @Override
    public void onClick(View view) {

        getHandler().onBtnClicked();
    }

    @Override
    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}