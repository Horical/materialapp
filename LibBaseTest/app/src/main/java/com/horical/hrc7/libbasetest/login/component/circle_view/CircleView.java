package com.horical.hrc7.libbasetest.login.component.circle_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by HRC7 on 7/6/2017.
 */

public class CircleView extends CircleStrategy {
    Paint paint;
    Paint paintBorder;
    boolean notStartDraw;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        notStartDraw = true;
        paintBorder = new Paint();
        paintBorder.setStyle(Paint.Style.STROKE);
        paintBorder.setStrokeWidth(1);
        paintBorder.setColor(Color.GRAY);
    }

    @Override
    protected void requestDrawNext() {
        invalidate();
    }

    @Override
    protected void delay(int timeDelay) {
        try {
            Thread.sleep(timeDelay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void drawCircle(Canvas canvas, int currentPercent) {
        canvas.drawArc(new RectF(100, 100, 200, 200), 0, currentPercent, true, paint);
    }

    @Override
    protected void drawBorderCircle(Canvas canvas) {
        canvas.drawArc(new RectF(100, 100, 200, 200), 0, 360, true, paintBorder);
    }

    @Override
    protected boolean isNotStartDraw() {
        return notStartDraw;
    }

    @Override
    protected boolean isFinishDraw() {
        if (currentPercent >= percent)
            return true;
        return false;
    }

    @Override
    protected void refreshAndBeginDraw() {
        currentPercent = 0;
        beginDraw();
    }

    @Override
    protected void beginDraw() {
        notStartDraw = false;
        invalidate();
    }
}
