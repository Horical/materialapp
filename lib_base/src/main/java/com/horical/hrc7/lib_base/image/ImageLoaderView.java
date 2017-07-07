package com.horical.hrc7.lib_base.image;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Billy Phan on 6/24/2017.
 */

public class ImageLoaderView extends android.support.v7.widget.AppCompatImageView {
    public ImageLoaderView(Context context) {
        super(context);
        onInit();
    }

    public ImageLoaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onInit();
    }

    public ImageLoaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInit();
    }

    protected void onInit() {

    }

    public void load(String url) {
        Glide.with(this)
                .load(url)
                .into(this);
    }
}
