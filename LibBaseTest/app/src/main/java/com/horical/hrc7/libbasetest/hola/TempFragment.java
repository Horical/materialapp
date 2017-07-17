package com.horical.hrc7.libbasetest.hola;

import android.os.Bundle;

import com.horical.hrc7.lib_base.fragment.BaseFragment;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;

import com.horical.hrc7.libbasetest.R;

/**
 * Created by HRC7 on 7/4/2017.
 */

@MyLayout(name = "fragment_temp")
public class TempFragment extends BaseFragment<TempFragment.Item, TempFragment.Listener> {
    private static final String ARG_PARAM = "ARG_PARAM";
    private String param;

    public TempFragment() {

    }

    public static TempFragment newInstance(String param) {
        TempFragment fragment = new TempFragment();
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
    public void bind(Item item) {
        super.bind(item);
        // TODO: bind data to view

    }

    public interface Item {

    }

    public interface Listener {
    }
}
