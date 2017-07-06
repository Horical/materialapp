package com.horical.hrc7.materialapp.login.install;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.horical.hrc7.lib_base.base.BaseActivity;
import com.horical.hrc7.lib_base.base.anotation.MyHandler;
import com.horical.hrc7.lib_base.base.anotation.MyServe;
import com.horical.hrc7.lib_base.dialog.DialogPool;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.loading.SpinLoading;
import com.horical.hrc7.lib_base.recycle_view.MyAdapter;
import com.horical.hrc7.materialapp.R;
import com.horical.hrc7.materialapp.login.ILoginView;
import com.horical.hrc7.materialapp.login.component.MemeDialog;
import com.horical.hrc7.materialapp.login.view_struct.IUserLogin;
import com.horical.hrc7.materialapp.login.component.ItemUserHolder;
import com.horical.hrc7.materialapp.login.view_struct.UserLogin;

import java.util.ArrayList;
import java.util.List;

@MyHandler(LoginHandler.class)
@MyServe(LoginServe.class)
public class LoginActivity extends BaseActivity<ILoginView.Handler> implements ILoginView, View.OnClickListener {
    @ViewChild(R.id.login_name)
    EditText name;

    @ViewChild(R.id.login_pass)
    EditText pass;

    @ViewChild(R.id.login_btn)
    Button login;

    @ViewChild(R.id.rec)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void setupView() {
        login.setOnClickListener(this);
        DialogPool.with(this, MemeDialog.class).bind("hello world").show();
//        SpinLoading spinLoading = SpinLoading.newInstance(this);
//        spinLoading.show();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<UserLogin> userLogins = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userLogins.add(new UserLogin("abc " + i, "def " + i));
        }
        MyAdapter myAdapter = new MyAdapter(userLogins, ItemUserHolder.class);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setListener(new ItemUserHolder.ItemUserListener() {
            @Override
            public void onNameClicked(UserLogin item) {
                toast(item.getUsername());
            }
        });
    }

    @Override
    public void onClick(View view) {
        getHandler().onLoginClicked();
    }

    @Override
    public void bindHint(IUserLogin body) {
        name.setText(body.getUsername());
        pass.setText(body.getPassword());
    }

    @Override
    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
