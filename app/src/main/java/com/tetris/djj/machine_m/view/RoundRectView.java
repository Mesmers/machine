package com.tetris.djj.machine_m.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;

import com.tetris.djj.machine_m.BaseView;
import com.tetris.djj.machine_m.R;

import java.text.DecimalFormat;

/**
 * Created by hehe on 2016/7/18.
 */
public class RoundRectView extends BaseView {

    private int[] colors = new int[]{R.color.procedure_process_start_color, R.color.procedure_process_stop_color};

    private float roundHeight = 30;
    private float radius = 15;

    private RectF rectF;

    private String text;
    private float range = 0;

    private float mWidthPosition = 0;
    private DecimalFormat df;

    public RoundRectView(Context context) {
        super(context);
        initDensity();
        df = new java.text.DecimalFormat("#.##");
    }

    public RoundRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDensity();
        df = new java.text.DecimalFormat("#.##");
    }

    public void setData(float data) {
        text = df.format(data * 100) + "%";
        range = data;
        mWidthPosition = 0;
        invalidate();
    }

    private void initPaint() {
        rectF = new RectF();
        rectF.left = 0;
        rectF.top = mHeight - roundHeight;
        rectF.right = mWidth;
        rectF.bottom = mHeight;

    }

    private void initDensity() {
        roundHeight *= density;
        radius *= density;

        mWidth = 150 * density;
        mHeight = 100 * density;

        mCenterX = mWidth / 2;
        mCenterY = 35 * density;
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (canvas) {
            drawBackRoundRect(canvas);
            drawRoundRect(canvas, mWidthPosition);
            drawText(canvas, text);

            if (mWidthPosition < mWidth * range) {
                invalidate();
                mWidthPosition += 10;
            }
        }
    }

    private void drawBackRoundRect(Canvas canvas) {
        Paint paint = getPaint(ContextCompat.getColor(mContext, R.color.bg_round));
        canvas.drawRoundRect(rectF, radius, radius, paint);
    }

    private void drawRoundRect(Canvas canvas, float mWidthPosition) {
        RectF rectF = new RectF();
        rectF.left = 0;
        rectF.top = mHeight - roundHeight;
        rectF.right = mWidthPosition;
        rectF.bottom = mHeight;
        Paint paint = getPaint(Color.WHITE);
        LinearGradient gradient = new LinearGradient(0, mHeight - roundHeight, mWidth * range, mHeight, colors, null, Shader.TileMode.MIRROR);
        paint.setShader(gradient);
        canvas.drawRoundRect(rectF, radius, radius, paint);
    }

    private void drawText(Canvas canvas, String text) {
        Paint paint = getPaint(ContextCompat.getColor(mContext, R.color.procedure_process_text_color));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(mContext.getResources().getDimension(R.dimen.actual_process_text));
        canvas.drawText(text, mCenterX, mCenterY, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) mWidth, (int) (mHeight));
    }
}
