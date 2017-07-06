package com.horical.hrc7.materialapp.login.component;

import android.view.View;
import android.widget.TextView;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.recycle_view.BaseViewHolder;
import com.horical.hrc7.materialapp.R;
import com.horical.hrc7.materialapp.login.view_struct.UserLogin;

/**
 * Created by HRC7 on 6/30/2017.
 */
@MyLayout(R.layout.item_view_user)
public class ItemUserHolder extends BaseViewHolder<UserLogin, ItemUserHolder.ItemUserListener> implements View.OnClickListener {

    @ViewChild(R.id.item_user_name)
    TextView name;

    public ItemUserHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setupView() {
        name.setOnClickListener(this);
    }

    @Override
    protected void onBind(UserLogin userLogin) {
        this.name.setText(userLogin.getUsername());
    }

    @Override
    public void onClick(View view) {
        getListener().onNameClicked(getItem());
    }

    public interface ItemUserListener {
        void onNameClicked(UserLogin item);
    }
}
