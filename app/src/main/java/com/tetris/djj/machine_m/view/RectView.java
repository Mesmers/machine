package com.tetris.djj.machine_m.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.tetris.djj.machine_m.BaseView;
import com.tetris.djj.machine_m.R;

/**
 * Created by hehe on 2016/7/17.
 */
public class RectView extends BaseView {

    private int color;

    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attributeSet){
        TypedArray array = mContext.obtainStyledAttributes(attributeSet, R.styleable.RectView);
        color = array.getColor(R.styleable.RectView_rect_color, ContextCompat.getColor(mContext,R.color.normal_machine));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (canvas){
            drawRect(canvas);
        }
    }

    private void drawRect(Canvas canvas){
        RectF rectF = new RectF();
        rectF.left = 0;
        rectF.top = 0;
        rectF.right = mWidth;
        rectF.bottom = mHeight;
        canvas.drawRect(rectF,getPaint(color));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getWidth();
        mHeight = getHeight();
        mCenterX = mWidth/2;
        mCenterY = mHeight/2;
    }
}
