package com.horical.hrc7.libbasetest.login.component.custom_view.circle_view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.horical.hrc7.lib_base.custom_view.BaseView;
import com.horical.hrc7.lib_base.helper.finder.MyAttr;

/**
 * Created by HRC7 on 7/6/2017.
 */

public abstract class CircleStrategy extends BaseView {

    private static final int DELTA_PERCENT = 5;

    protected int percent;
    protected int timeDelay;
    protected int currentPercent;

    public CircleStrategy(Context context) {
        super(context);
    }

    public CircleStrategy(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleStrategy(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit(AttributeSet attrs) {
        super.onInit(attrs);
        percent = 0;
        timeDelay = 0;
        currentPercent = 0;
        setWillNotDraw(false);
    }

    @Override
    protected void onBind(Object item) {

    }

    public void bind(int percent, int timeDelay) {
        this.percent = percent;
        this.timeDelay = timeDelay;
        beginDraw();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBorderCircle(canvas);
        super.onDraw(canvas);
        if (isNotStartDraw()) {
            return;
        }
        drawCircle(canvas, currentPercent);
        delay(timeDelay);
        currentPercent += DELTA_PERCENT;
        if (!isFinishDraw())
            requestDrawNext();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                onTouch();
                break;
        }
        return super.onTouchEvent(event);
    }

    private void onTouch() {
        refreshAndBeginDraw();
    }

    protected abstract void requestDrawNext();

    protected abstract void delay(int timeDelay);

    protected abstract void drawCircle(Canvas canvas, int currentPercent);

    protected abstract void drawBorderCircle(Canvas canvas);

    protected abstract boolean isNotStartDraw();

    protected abstract boolean isFinishDraw();

    protected abstract void refreshAndBeginDraw();

    protected abstract void beginDraw();

}
