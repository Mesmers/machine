package com.tetris.djj.machine_m.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tetris.djj.machine_m.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/1.
 */
public class MainHomeOption extends RelativeLayout implements View.OnClickListener{

    @Bind(R.id.img_main_home_option)
    ImageView mImgHomeOption;
    @Bind(R.id.tv_main_home_option)
    TextView mTvHomeOption;

    private View mView;
    private Context mContext;
    private TypedArray typedArray;
    private Drawable mMiddleIcon;
    private String mText;
    private String target;

    public MainHomeOption(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.widget_viewgroup_home_option,this,true);
        ButterKnife.bind(this,mView);
        mContext = context;
        typedArray = mContext.obtainStyledAttributes(attrs,R.styleable.MainCircleView);
        initAttrs();
        setOnClickListener(this);
    }

    private void initAttrs(){
        int n = typedArray.getIndexCount();
        int attr;
        for (int i = 0 ; i < n ; i ++ ){
            attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.MainCircleView_src_pic:
                    mMiddleIcon = typedArray.getDrawable(attr);
                    break;
                case R.styleable.MainCircleView_text_below:
                    mText = typedArray.getString(attr);
                    break;
                case R.styleable.MainCircleView_target:
                    target = "com.tetris.djj.machine_m.activity.main.home."+typedArray.getString(attr);
                    break;
            }
        }
        typedArray.recycle();
        mImgHomeOption.setImageDrawable(mMiddleIcon);
        mTvHomeOption.setText(mText);
    }

    @Override
    public void onClick(View v) {
        try {
            startActivity();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void startActivity() throws ClassNotFoundException {
        Class c = Class.forName(target);
        mContext.startActivity(new Intent(mContext, c));
    }
}
