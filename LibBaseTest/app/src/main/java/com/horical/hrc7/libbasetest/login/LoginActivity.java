package com.horical.hrc7.libbasetest.login;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.horical.hrc7.lib_base.base.BaseActivity;
import com.horical.hrc7.lib_base.base.anotation.MyHandler;
import com.horical.hrc7.lib_base.base.anotation.MyServe;

import com.horical.hrc7.lib_base.dialog.DialogPool;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.recycle_view.MyAdapter;
import com.horical.hrc7.libbasetest.login.component.Hello;
import com.horical.hrc7.libbasetest.login.component.ItemUserHolder;
import com.horical.hrc7.libbasetest.login.component.User;
import com.horical.hrc7.libbasetest.login.install.LoginHandler;
import com.horical.hrc7.libbasetest.login.install.LoginServe;
import com.horical.hrc7.libbasetest.R;

import java.util.ArrayList;
import java.util.List;

@MyHandler(LoginHandler.class)
@MyServe(LoginServe.class)
public class LoginActivity extends BaseActivity<ILoginView.Handler> implements ILoginView, ItemUserHolder.Listener {
    @ViewChild(R.id.recy)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    List<User> userList;

    @Override
    protected void setupView() {
        userList = new ArrayList<>();
        userList.add(new User("sdfsdf"));
        userList.add(new User("sdfsdf 1"));
        userList.add(new User("sdfsdf 2"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MyAdapter myAdapter = new MyAdapter(userList, ItemUserHolder.class);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setListener(this);
    }

    @Override
    public void onUserOnClicked(User item) {
        DialogPool
                .with(this, Hello.class)
                .bind(item).show();
    }
}