package com.tetris.djj.machine_m.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.tetris.djj.machine_m.BaseView;
import com.tetris.djj.machine_m.R;

/**
 * Created by hehe on 2016/7/9.
 */
public class MyTextView extends BaseView {

    private int mBackColor,mTextColor;
    private String text;

    public MyTextView(Context context,float width,int height) {
        super(context);
        mWidth = width;
        mHeight = height;
    }


    public void setMyColor(int mBackColor,int mTextColor,String text) {
        this.mBackColor = ContextCompat.getColor(mContext,mBackColor);
        this.mTextColor = ContextCompat.getColor(mContext,mTextColor);
        this.text = text;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (canvas) {
            canvas.drawColor(mBackColor);
            drawText(canvas, text);
        }
    }

    private void drawText(Canvas canvas,String text){
        Paint paint = getPaint(mTextColor);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(mContext.getResources().getDimension(R.dimen.my_text_view_text));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float fontHeight = fontMetrics.bottom - fontMetrics.top;
        float baseY =fontHeight/2+mCenterY-fontMetrics.bottom;
        canvas.drawText(text,mCenterX,baseY,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("tw", mWidth + "");
        Log.e("th", mHeight + "");
        mCenterX = mWidth/2;
        mCenterY = mHeight/2;
        setMeasuredDimension((int)mWidth,(int)mHeight);
    }
}
