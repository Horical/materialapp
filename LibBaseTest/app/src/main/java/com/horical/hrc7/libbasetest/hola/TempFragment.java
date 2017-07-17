package com.horical.hrc7.libbasetest.hola;

import android.os.Bundle;
import android.widget.TextView;

import com.horical.hrc7.lib_base.fragment.BaseFragment;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;

import com.horical.hrc7.lib_base.helper.finder.ViewChild;
import com.horical.hrc7.libbasetest.R;

/**
 * Created by HRC7 on 7/4/2017.
 */

@MyLayout(name = "fragment_temp")
public class TempFragment extends BaseFragment<TempFragment.Item, TempFragment.Listener> {
    private static final String ARG_PARAM = "ARG_PARAM";
    private String param;
    @ViewChild
    TextView frag_text;

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
    protected void onBind(Item item) {
        frag_text.setText(item.getTitle());
    }

    public interface Item {

        String getTitle();
    }

    public interface Listener {
    }
}
