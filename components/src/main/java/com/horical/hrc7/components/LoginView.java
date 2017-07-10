package com.horical.hrc7.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.helper.finder.ViewFinder;


/**
 * Created by HRC7 on 7/6/2017.
 */

@MyLayout(name = "view_login")
public class LoginView extends FrameLayout implements View.OnClickListener {
    private Item item;
    private Listener listener;

    @ViewChild
    EditText user_name;

    @ViewChild
    EditText password;

    @ViewChild
    Button login;

    public LoginView(Context context) {
        super(context);
        onInit(null);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onInit(attrs);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInit(attrs);
    }

    private void onInit(AttributeSet attrs) {
        ViewFinder.load(this);
        login.setOnClickListener(this);
    }

    public void bind(Item item) {
        this.item = item;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (view == login) listener.onLoginClicked();
    }

    public boolean isValid() {
        if (this.user_name.getText().toString().length() > 3
                && this.password.getText().toString().length() > 3)
            return true;
        return false;
    }

    public interface Item {

        String getUserName();

        String getPassword();
    }

    public interface Listener {
        void onLoginClicked();
    }

}
