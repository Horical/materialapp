package com.horical.hrc7.materialapp.test.component;

import android.os.Bundle;

import com.horical.hrc7.lib_base.fragment.BaseFragment;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;

import com.horical.hrc7.materialapp.R;

/**
 * Created by HRC7 on 7/4/2017.
 */

@MyLayout(name = "fragment_temp1")
public class Temp1Fragment extends BaseFragment<Temp1Fragment.Item, Temp1Fragment.Listener> {
    private static final String ARG_PARAM = "ARG_PARAM";
    private String param;

    public Temp1Fragment() {

    }

    public static Temp1Fragment newInstance(String param) {
        Temp1Fragment fragment = new Temp1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    protected void setupView() {

    }


    @Override
    protected void onBind(Item item) {

    }

    public interface Item {

    }

    public interface Listener {
    }
}
