package com.horical.hrc7.lib_base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horical.hrc7.lib_base.helper.finder.ViewFinder;

/**
 * Created by HRC7 on 7/4/2017.
 */

public abstract class BaseFragment<T, K> extends Fragment {
    T item;
    K listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return ViewFinder.load(this, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupView();
        if (item != null)
            onBind(item);
    }

    public void bind(T item) {
        this.item = item;
        if (isAdded())
            onBind(item);
    }

    public void setListener(K listener) {
        this.listener = listener;
    }

    protected K getListener() {
        return listener;
    }

    protected abstract void setupView();

    protected abstract void onBind(T item);

}
