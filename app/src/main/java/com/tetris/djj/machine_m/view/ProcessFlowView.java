package com.tetris.djj.machine_m.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.tetris.djj.machine_m.BaseView;
import com.tetris.djj.machine_m.R;

/**
 * Created by hehe on 2016/7/2.工艺流程
 */
public class ProcessFlowView extends BaseView {

    private int[] mProcedureStatus = new int[0];
    private String[] mProcedures = new String[0];

    //工序
    private float mProcedureHeight = 50, mProcedureWidth = 0;//工序的长宽

    //箭头
    private float mArrowWidth = 0;//直箭头的长度
    private float mArrowTipWidth = 10, mArrowTipHeight = 6, mArrowMargin = 2, mArrowAndTipMargin = 8;
    private float mBendArrowWidth = 0;//弯箭头上方长度
    private float mArrowStrokeWidth = 2;//箭头粗细

    private int mHeightLength;//工序个数除以3的余数
    private int mHeightNum;//工序个数除以3
    private float nowWidth, nowHeight;

    //工序的position
    private int position = 0;
    //行数的position
    private int linePosition = 0;


    private float mProcedureMargin = 40, mMargin = 15, mLeftOrRightMargin = 0;

    public ProcessFlowView(Context context, String[] mProcedures, int[] mProcedureStatus, float width, int height) {
        super(context);
        mWidth = width;
        mHeight = height;
        this.mProcedures = mProcedures;
        this.mProcedureStatus = mProcedureStatus;
        initDensity();
    }

    private void initDensity() {
        mProcedureWidth *= density;
        mProcedureHeight *= density;
        mProcedureMargin *= density;
        mMargin *= density;
        mArrowWidth *= density;
        mArrowTipWidth *= density;
        mArrowTipHeight *= density;
        mArrowMargin *= density;
        mArrowAndTipMargin *= density;
        mBendArrowWidth *= density;
        mArrowStrokeWidth = mContext.getResources().getDimension(R.dimen.process_flow_view_stroke)*density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (canvas) {
            init();
            drawProcedures(canvas);
        }
    }

    private void init() {
        position = 0;
        linePosition = 0;
        mLeftOrRightMargin = 26 * mWidth / 360;
        mProcedureWidth = (mWidth - mLeftOrRightMargin * 2) / 5;
        mArrowWidth = mProcedureWidth;
        mBendArrowWidth = 13 * mWidth / 360;
        nowWidth = mLeftOrRightMargin;
        nowHeight = mMargin;
        mHeightLength = mProcedures.length % 3;
        mHeightNum = mProcedures.length / 3;
        mHeight = mHeightNum * mProcedureHeight + (mHeightNum - 1) * mProcedureMargin + 2 * mMargin;
        if (mHeightLength != 0)
            mHeight += mProcedureHeight + mProcedureMargin;
    }

    private void drawProcedures(Canvas canvas) {
        for (int i = 0; i < mHeightNum; i++) {
            drawProcedureAndArrows(canvas, 3);
            linePosition++;
            if (i != mHeightNum - 1) {
                drawBendArrow(canvas, (linePosition + 1) % 2, mBendArrowWidth);
                nowHeight += mProcedureHeight + mProcedureMargin;
            }
        }
        switch (mHeightLength) {
            case 0:
                break;
            case 1:
                drawBendArrow(canvas, (linePosition + 1) % 2, mBendArrowWidth + 2 * mProcedureWidth);
                nowHeight += mProcedureHeight + mProcedureMargin;
                drawProcedureAndArrows(canvas, 1);
                break;
            case 2:
                drawBendArrow(canvas, (linePosition + 1) % 2, mBendArrowWidth + mProcedureWidth);
                nowHeight += mProcedureHeight + mProcedureMargin;
                drawProcedureAndArrows(canvas, 2);
                break;
        }
    }

    //画直箭头与工序
    private void drawProcedureAndArrows(Canvas canvas, int num) {
        int pos = linePosition % 2;
        for (int i = 0; i < num; i++) {
            drawTextView(canvas, mProcedureStatus[position], mProcedures[position], pos);
            switch (pos) {
                case 0:
                    nowWidth += mProcedureWidth;
                    if (i != num - 1)
                        nowHeight += mProcedureHeight / 2;
                    break;
                case 1:
                    nowWidth -= mProcedureWidth;
                    if (i != num - 1)
                        nowHeight += mProcedureHeight / 2;
                    break;
            }
            if (i != num - 1) {
                drawLineArrow(canvas, pos);
                switch (pos) {
                    case 0:
                        nowWidth += mProcedureWidth;
                        nowHeight -= mProcedureHeight / 2;
                        break;
                    case 1:
                        nowWidth -= mProcedureWidth;
                        nowHeight -= mProcedureHeight / 2;
                        break;
                }
            }
            position++;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    //画弯箭头
    private void drawBendArrow(Canvas canvas, int pos, float mArrowBottomWidth) {
        nowHeight += mProcedureHeight / 2;
        Paint paint = getPaint(ContextCompat.getColor(mContext, R.color.arrow_color));
        paint.setStrokeWidth(mArrowStrokeWidth);
        switch (pos) {
            case 0:
                canvas.drawLine(nowWidth, nowHeight, nowWidth + mBendArrowWidth, nowHeight, paint);
                canvas.drawLine(nowWidth + mBendArrowWidth, nowHeight-paint.getStrokeWidth()/2, nowWidth + mBendArrowWidth, nowHeight + mProcedureMargin + mProcedureHeight+paint.getStrokeWidth()/2, paint);
                canvas.drawLine(nowWidth + mBendArrowWidth, nowHeight + mProcedureMargin + mProcedureHeight, nowWidth + mBendArrowWidth - mArrowBottomWidth + mArrowAndTipMargin, nowHeight+ mProcedureMargin + mProcedureHeight, paint);
                break;
            case 1:
                canvas.drawLine(nowWidth, nowHeight, nowWidth - mBendArrowWidth, nowHeight, paint);
                canvas.drawLine(nowWidth - mBendArrowWidth, nowHeight-paint.getStrokeWidth()/2, nowWidth - mBendArrowWidth, nowHeight + mProcedureMargin + mProcedureHeight+paint.getStrokeWidth()/2, paint);
                canvas.drawLine(nowWidth - mBendArrowWidth, nowHeight + mProcedureMargin + mProcedureHeight, nowWidth - mBendArrowWidth + mArrowBottomWidth - mArrowAndTipMargin, nowHeight + mProcedureMargin + mProcedureHeight, paint);
                break;
        }
        Path path = new Path();
        paint = getPaint(ContextCompat.getColor(mContext, R.color.arrow_color));
        switch (pos) {
            case 0:
                path.moveTo(nowWidth + mBendArrowWidth - mArrowBottomWidth + mArrowAndTipMargin, nowHeight + mProcedureMargin + mProcedureHeight - mArrowMargin);
                path.lineTo(nowWidth + mBendArrowWidth - mArrowBottomWidth + mArrowAndTipMargin + mArrowTipWidth - mArrowAndTipMargin, nowHeight - mArrowMargin + mProcedureMargin + mProcedureHeight - mArrowTipHeight);
                path.lineTo(nowWidth + mBendArrowWidth - mArrowBottomWidth, nowHeight + mProcedureMargin + mProcedureHeight);
                path.lineTo(nowWidth + mBendArrowWidth - mArrowBottomWidth + mArrowAndTipMargin + mArrowTipWidth - mArrowAndTipMargin, nowHeight + mArrowMargin + mProcedureMargin + mProcedureHeight + mArrowTipHeight);
                path.lineTo(nowWidth + mBendArrowWidth - mArrowBottomWidth + mArrowAndTipMargin, nowHeight + mProcedureMargin + mProcedureHeight + mArrowMargin);
                nowWidth = nowWidth + mBendArrowWidth - mArrowBottomWidth;
                break;
            case 1:
                path.moveTo(nowWidth - mBendArrowWidth + mArrowBottomWidth - mArrowAndTipMargin, nowHeight + mProcedureMargin + mProcedureHeight - mArrowMargin);
                path.lineTo(nowWidth - mBendArrowWidth + mArrowBottomWidth - mArrowAndTipMargin - mArrowTipWidth + mArrowAndTipMargin, nowHeight - mArrowMargin + mProcedureMargin + mProcedureHeight - mArrowTipHeight);
                path.lineTo(nowWidth - mBendArrowWidth + mArrowBottomWidth, nowHeight + mProcedureMargin + mProcedureHeight);
                path.lineTo(nowWidth - mBendArrowWidth + mArrowBottomWidth - mArrowAndTipMargin - mArrowTipWidth + mArrowAndTipMargin, nowHeight + mArrowMargin + mProcedureMargin + mProcedureHeight + mArrowTipHeight);
                path.lineTo(nowWidth - mBendArrowWidth + mArrowBottomWidth - mArrowAndTipMargin, nowHeight + mProcedureMargin + mProcedureHeight + mArrowMargin);
                nowWidth = nowWidth - mBendArrowWidth + mArrowBottomWidth;
                break;
        }
        path.close();
        canvas.drawPath(path, paint);
        nowHeight -= mProcedureHeight / 2;
    }

    //画直箭头
    private void drawLineArrow(Canvas canvas, int pos) {
        Path path = new Path();
        path.moveTo(nowWidth, nowHeight - mArrowMargin);
        float m = mProcedureWidth - mArrowAndTipMargin;
        switch (pos) {
            case 0:
                path.lineTo(nowWidth + m, nowHeight - mArrowMargin);
                path.lineTo(nowWidth + m - mArrowTipWidth + mArrowAndTipMargin, nowHeight - mArrowMargin - mArrowTipHeight);
                path.lineTo(nowWidth + mProcedureWidth, nowHeight);
                path.lineTo(nowWidth + m - mArrowTipWidth + mArrowAndTipMargin, nowHeight + mArrowMargin + mArrowTipHeight);
                path.lineTo(nowWidth + m, nowHeight + mArrowMargin);
                path.lineTo(nowWidth, nowHeight + mArrowMargin);
                break;
            case 1:
                path.lineTo(nowWidth - m, nowHeight - mArrowMargin);
                path.lineTo(nowWidth - m + mArrowTipWidth - mArrowAndTipMargin, nowHeight - mArrowMargin - mArrowTipHeight);
                path.lineTo(nowWidth - mProcedureWidth, nowHeight);
                path.lineTo(nowWidth - m + mArrowTipWidth - mArrowAndTipMargin, nowHeight + mArrowMargin + mArrowTipHeight);
                path.lineTo(nowWidth - m, nowHeight + mArrowMargin);
                path.lineTo(nowWidth, nowHeight + mArrowMargin);
                break;
        }
        path.close();
        Paint paint = getPaint(ContextCompat.getColor(mContext, R.color.arrow_color));
        canvas.drawPath(path, paint);
    }

    //画工序
    private void drawTextView(Canvas canvas, int color, String text, int pos) {
        Paint paint = getPaint(ContextCompat.getColor(mContext, color));
        RectF rectF = new RectF();
        switch (pos) {
            case 0:
                rectF.left = nowWidth;
                rectF.top = nowHeight;
                rectF.right = nowWidth + mProcedureWidth;
                rectF.bottom = nowHeight + mProcedureHeight;
                break;
            case 1:
                rectF.left = nowWidth - mProcedureWidth;
                rectF.top = nowHeight;
                rectF.right = nowWidth;
                rectF.bottom = nowHeight + mProcedureHeight;
                break;
        }
        canvas.drawRect(rectF, paint);
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(mContext.getResources().getDimension(R.dimen.my_text_view_text));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float fontHeight = fontMetrics.bottom - fontMetrics.top;
        float baseY = fontHeight / 2 + nowHeight + mProcedureHeight / 2 - fontMetrics.bottom;
        switch (pos) {
            case 0:
                canvas.drawText(text, nowWidth + mProcedureWidth / 2, baseY, paint);
                break;
            case 1:
                canvas.drawText(text, nowWidth - mProcedureWidth / 2, baseY, paint);
                break;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mWidth != 0) {
            init();
            setMeasuredDimension((int) mWidth, (int) (mHeight));
        }
    }
}
