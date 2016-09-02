package com.tetris.djj.machine_m.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.tetris.djj.machine_m.BaseView;
import com.tetris.djj.machine_m.R;

/**
 * Created by hehe on 2016/7/9.
 */
public class MyLineArrow extends BaseView {

    private float mArrowTipWidth = 10, mArrowTipHeight = 6, mMargin = 8, mArrowMargin = 2;
    private int color;

    public MyLineArrow(Context context, float width, int height) {
        super(context);
        mWidth = width;
        mHeight = height;
        initDensity();
        color = ContextCompat.getColor(mContext, R.color.arrow_color);
    }

    private void initDensity() {
        mMargin *= density;
        mArrowMargin *= density;
        mArrowTipWidth *= density;
        mArrowTipHeight *= density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (canvas) {
            drawArrow(canvas);
        }
    }

    private void drawArrow(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0, mCenterY - mArrowMargin);
        path.lineTo(mWidth - mMargin, mCenterY - mArrowMargin);
        path.lineTo(mWidth - mMargin - mArrowTipWidth - mMargin, mCenterY - mArrowMargin - mArrowTipHeight);
        path.lineTo(mWidth, mCenterY);
        path.lineTo(mWidth - mMargin - mArrowTipWidth - mMargin, mCenterY + mArrowMargin + mArrowTipHeight);
        path.lineTo(mWidth - mMargin, mCenterY + mArrowMargin);
        path.lineTo(0, mCenterY + mArrowMargin);
        path.close();
        Paint paint = getPaint(color);
        canvas.drawPath(path, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("lw", mWidth + "");
        Log.e("lh", mHeight + "");
        mCenterX = mWidth / 2;
        mCenterY = mHeight / 2;
        setMeasuredDimension((int) mWidth, (int) mHeight);
    }

}
