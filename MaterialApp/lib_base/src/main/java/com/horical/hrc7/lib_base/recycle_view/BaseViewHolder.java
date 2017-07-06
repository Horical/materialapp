package com.horical.hrc7.lib_base.recycle_view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.horical.hrc7.lib_base.helper.finder.ViewFinder;

import java.util.List;

/**
 * Created by quang.pv on 6/1/2017.
 */

public abstract class BaseViewHolder<T, K> extends RecyclerView.ViewHolder {

    private K listener;
    protected T item;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setupView();

    public void bind(T item) {
        this.item = item;
        onBind(item);
    }

    protected abstract void onBind(T t);

    void onBindWithPayload(T t, List<Object> payloads) {
        onBind(t);
    }

    void setListener(K myViewHolderListener) {
        this.listener = myViewHolderListener;
    }

    public T getItem() {
        return item;
    }

    protected K getListener() {
        return listener;
    }
}
