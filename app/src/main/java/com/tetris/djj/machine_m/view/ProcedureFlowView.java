package com.tetris.djj.machine_m.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;

import com.tetris.djj.machine_m.BaseView;
import com.tetris.djj.machine_m.R;

/**
 * Created by hehe on 2016/7/14.
 */
public class ProcedureFlowView extends BaseView {

    private int[] colors = new int[]{R.color.procedure_process_start_color,R.color.procedure_process_stop_color};

    private float leftMargin;
    private float radius;
    private float bottomMargin;
    private float bottomText;
    private float topText;

    private String text="";
    private float fText=0;
    private float nowF=0;
    private Handler handler;

    private Paint paint;//画圆弧的Paint
    private RectF rectF;//圆弧对应的RectF

    public void setText(String text) {
        this.text = text;
        fText = Float.parseFloat(text);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (nowF<fText) {
                    try {
                        Thread.sleep(10);
                        nowF+=0.5;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                invalidate();
                            }
                        });
                        Log.e("nowF",nowF+"");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public ProcedureFlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        handler = new Handler();
        initColor();
        initPaint();
    }

    private void initPaint(){
        paint = getPaint(Color.WHITE);
        paint.setStrokeWidth(mContext.getResources().getDimension(R.dimen.procedure_view_stroke));
        LinearGradient gradient = new LinearGradient(0,mHeight,mWidth,mHeight,colors,null, Shader.TileMode.MIRROR);
        paint.setShader(gradient);
        paint.setStyle(Paint.Style.STROKE);
        rectF = new RectF(mCenterX-radius,mCenterY-radius,mCenterX+radius,mCenterY+radius);
    }

    private void initColor(){
        for (int i = 0 ; i < colors.length;i++)
            colors[i] = ContextCompat.getColor(mContext,colors[i]);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (canvas){
            drawBackArc(canvas);
            drawText(canvas, text + "%");
            drawArc(canvas,nowF*180/100);
        }
    }

    private void drawBackArc(Canvas canvas){
        Paint paint = getPaint(Color.WHITE);
        paint.setStrokeWidth(mContext.getResources().getDimension(R.dimen.procedure_view_stroke));
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(mCenterX-radius,mCenterY-radius,mCenterX+radius,mCenterY+radius);
        canvas.drawArc(rectF, 0, -180, false, paint);
        paint = getPaint(ContextCompat.getColor(mContext,R.color.procedure_process_color));
        paint.setTextSize(mContext.getResources().getDimension(R.dimen.procedure_process_start_or_stop_text));
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("0%", mCenterX - radius, mCenterY + topText, paint);
        canvas.drawText("100%",mCenterX+radius,mCenterY+topText,paint);
    }

    private void drawArc(Canvas canvas,float angle){
        canvas.drawArc(rectF, 180,angle, false, paint);
//        paint.setColor(Color.WHITE);
//        canvas.drawArc(rectF,);
    }

    private void drawText(Canvas canvas,String text){
        Paint paint = getPaint(ContextCompat.getColor(mContext,R.color.procedure_process_text_color));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(mContext.getResources().getDimension(R.dimen.procedure_process_text));
        canvas.drawText(text,mCenterX,mCenterY-bottomText,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getWidth();
        mHeight = getHeight();
        leftMargin = 28*mWidth/220;
        bottomMargin = 30*mHeight/134;
        mCenterX = (mWidth-leftMargin)/2;
        mCenterY = mHeight-bottomMargin;
        radius = 75*mHeight/130;
        bottomText = 10*mHeight/134;
        topText = 18*mHeight/134;
        initPaint();
    }
}
