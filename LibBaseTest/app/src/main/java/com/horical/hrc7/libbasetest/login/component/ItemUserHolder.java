package com.horical.hrc7.libbasetest.login.component;

import android.view.View;
import android.widget.TextView;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.lib_base.recycle_view.BaseViewHolder;
import com.horical.hrc7.libbasetest.R;

/**
 * Created by HRC7 on 6/30/2017.
 */
@MyLayout(R.layout.item_view_user)
public class ItemUserHolder extends BaseViewHolder<User, ItemUserHolder.Listener> implements View.OnClickListener {

    @ViewChild(R.id.holder)
    TextView user;

    public ItemUserHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setupView() {
        user.setOnClickListener(this);
    }

    @Override
    protected void onBind(User item) {
        this.user.setText(item.getName());
    }

    @Override
    public void onClick(View view) {
        getListener().onUserOnClicked(item);
    }


    public interface Listener {

        void onUserOnClicked(User item);
    }
}
