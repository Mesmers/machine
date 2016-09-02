package com.tetris.djj.machine_m;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by hehe on 2016/7/9.
 */
public class BaseView extends View {

    protected float mWidth,mHeight;
    protected float mCenterX,mCenterY;
    protected Context mContext;
    protected TypedArray typedArray;
    protected float density;

    public BaseView(Context context){
        super(context);
        mContext = context;
        density = mContext.getResources().getDisplayMetrics().density;
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        density = mContext.getResources().getDisplayMetrics().density;
    }

    protected Paint getPaint(int color) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        paint.setAntiAlias(true);
        return paint;
    }

}
