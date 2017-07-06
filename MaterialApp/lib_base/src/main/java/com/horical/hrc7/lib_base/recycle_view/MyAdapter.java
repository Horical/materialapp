package com.horical.hrc7.lib_base.recycle_view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horical.hrc7.lib_base.helper.finder.MyLayout;
import com.horical.hrc7.lib_base.helper.finder.ViewFinder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by quang.pv on 6/1/2017.
 */

public class MyAdapter extends RecyclerView.Adapter {
    List items;
    Class clazz;
    Object listener;

    public MyAdapter(List items, Class clazz) {
        this.items = items;
        this.clazz = clazz;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        try {
            if (clazz == null) throw new NullPointerException("Clazz null");
            int resource = getResourceValue();
            View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
            Object obj = clazz.getConstructor(View.class).newInstance(view);

            if (!(obj instanceof RecyclerView.ViewHolder))
                throw new ExceptionInInitializerError("clazz not instance of ViewHolder");

//            Load child view for view holder
            viewHolder = (RecyclerView.ViewHolder) obj;
            ViewFinder.loadViewHolder(viewHolder);

//            Invoke setup view
            Method setupView = clazz.getSuperclass().getMethod("setupView");
            setupView.invoke(viewHolder);

            if (viewHolder instanceof BaseViewHolder) {
                BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
                baseViewHolder.setListener(listener);
            }

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
        baseViewHolder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {

        if (payloads.isEmpty())
            super.onBindViewHolder(holder, position, payloads);
        else {
            BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
            baseViewHolder.onBindWithPayload(items.get(position), payloads);
        }

    }

    public int getResourceValue() throws ClassNotFoundException {
        MyLayout myLayout = (MyLayout) this.clazz.getAnnotation(MyLayout.class);
        if (myLayout == null) throw new RuntimeException("Can't found layout Id");
        return myLayout.value();
    }

    public <K> void setListener(K listener) {
        this.listener = listener;
    }
}
