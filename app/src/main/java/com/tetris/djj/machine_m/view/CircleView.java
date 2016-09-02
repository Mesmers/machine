package com.tetris.djj.machine_m.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.tetris.djj.machine_m.BaseView;
import com.tetris.djj.machine_m.R;

/**
 * Created by hehe on 2016/7/15.
 */
public class CircleView extends BaseView {

    private int color;
    private int[] colors = new int[]{R.color.not_select_color,R.color.select_color};
    private float radius=5;

    public CircleView(Context context) {
        super(context);
        initColor();
        initDensity();
    }

    private void initDensity(){
        radius*=density;
        mWidth=30*density;
        mHeight=30*density;
    }

    private void initColor(){
        for (int i = 0 ; i < colors.length ; i++)
            colors[i] = ContextCompat.getColor(mContext,colors[i]);
        color = colors[0];
    }

    public void setSelect(boolean select){
        if (select)
            color = colors[1];
        else
            color = colors[0];
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (canvas){
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas){
        canvas.drawCircle(mCenterX,mCenterY,radius,getPaint(color));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mCenterX = mWidth/2;
        mCenterY = mHeight/2;
        setMeasuredDimension((int) mWidth, (int) (mHeight));
    }
}
