package com.tetris.djj.machine_m.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import com.tetris.djj.machine_m.BaseView;

/**
 * Created by hehe on 2016/7/13.
 */
public class MyProcedureFlow extends BaseView {

    private int[] mProcedureStatus = new int[0];
    private String[] mProcedures = new String[0];

    private float mProcedureHeight = 40, mProcedureWidth=0;//工序的长宽

    private int mHeightLength;//工序个数除以3的余数
    private int mHeightNum;

    private float nowWidth, nowHeight;

    private int position = 0;

    private float mProcedureMargin = 30, mMargin = 15, mLeftOrRightMargin=0;

    public MyProcedureFlow(Context context, String[] mProcedures, int[] mProcedureStatus) {
        super(context);
        this.mProcedures = mProcedures;
        this.mProcedureStatus = mProcedureStatus;
        initDensity();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initDensity() {
        mProcedureWidth *= density;
        mProcedureHeight *= density;
        mProcedureMargin *= density;
        mMargin *= density;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("w", mWidth + "");
        Log.e("h", mHeight + "");
        if (getWidth()==0)
            return;
        else {
            mWidth = getWidth();
            mHeight = getHeight();
            mLeftOrRightMargin = 26 * mWidth / 360;
            mProcedureWidth = (mWidth - mLeftOrRightMargin * 2) / 5;
            nowWidth = mLeftOrRightMargin;
            nowHeight = mMargin;
            mHeightLength = mProcedures.length % 3;
            mHeightNum = mProcedures.length / 3;
            mHeight = mHeightLength * mProcedureHeight + (mHeightLength - 1) * mProcedureMargin + 2 * mMargin;
            setMeasuredDimension((int) mWidth, (int) (mHeight));
        }
    }
}
