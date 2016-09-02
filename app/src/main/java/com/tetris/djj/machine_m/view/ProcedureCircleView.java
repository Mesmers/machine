package com.tetris.djj.machine_m.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.tetris.djj.machine_m.BaseView;

/**
 * Created by hehe on 2016/7/17.
 */
public class ProcedureCircleView extends BaseView {

    private float radius = 20;
    private int statusColor;
    private float backPx = 2;

    public ProcedureCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        statusColor = Color.WHITE;
        backPx *= density;
        radius *= density;
    }

    public ProcedureCircleView(Context context) {
        super(context);
        statusColor = Color.WHITE;
        backPx *= density;
        radius *= density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (canvas) {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(mCenterX, mCenterY, radius + backPx, getPaint(Color.WHITE));
        canvas.drawCircle(mCenterX, mCenterY, radius, getPaint(ContextCompat.getColor(mContext,statusColor)));
    }

    public void setStatusColor(int color) {
        statusColor = color;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getWidth();
        mCenterX = mWidth / 2;
        mCenterY = 20*density;
    }
}
