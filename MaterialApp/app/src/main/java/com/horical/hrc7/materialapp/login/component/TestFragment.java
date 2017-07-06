package com.horical.hrc7.materialapp.login.component;

import android.os.Bundle;
import com.horical.hrc7.lib_base.fragment.BaseFragment;
import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.materialapp.R;

/**
 * Created by HRC7 on 7/4/2017.
 */
@MyLayout(R.layout.fragment_test)
public class TestFragment extends BaseFragment<String, TestFragment.Listener> {
    private static final String ARG_PARAM = "ARG_PARAM";
    String param;

    public TestFragment() {
    }

    public static BlankFragment newInstance(String param) {
        BlankFragment fragment = new BlankFragment();
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
    protected void onBind(String item) {
    }

    public interface Listener {
    }
}
