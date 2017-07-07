package com.horical.hrc7.components.login;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.helper.finder.ViewFinder;

/**
 * Created by HRC7 on 7/7/2017.
 */

@MyLayout(name = "view_login")
public abstract class LoginView extends FrameLayout {

    protected Item item;

    @ViewChild(name = "username")
    protected EditText username;

    @ViewChild(name = "password")
    protected EditText password;

    @ViewChild(name = "click")
    protected Button button;

    public LoginView(@NonNull Context context) {
        super(context);
        onInit();
    }

    public LoginView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onInit();
    }

    public LoginView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInit();
    }

    private void onInit() {
        ViewFinder.load(this);
    }

    public void bind(Item iLogin) {
        this.item = iLogin;
        username.setText(iLogin.getUserName());
        password.setText(iLogin.getPassword());
    }

    public interface Item {

        int getUserName();

        int getPassword();
    }
}
