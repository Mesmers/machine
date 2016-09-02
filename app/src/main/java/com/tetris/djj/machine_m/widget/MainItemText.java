package com.tetris.djj.machine_m.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tetris.djj.machine_m.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/1.
 */
public class MainItemText extends RelativeLayout implements View.OnClickListener{

    @Bind(R.id.i_btn_widget_item_text)
    ImageButton mLeftImageBtn;
    @Bind(R.id.tv_widget_item_text)
    TextView mTvText;

    private View mView;

    private Drawable leftIcon;
    private String mText;
    private Context mContext;
    private TypedArray typedArray;

    public MainItemText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.widget_viewgroup_item_text,this,true);
        ButterKnife.bind(this,mView);
        mContext = context;
        typedArray = mContext.obtainStyledAttributes(attrs,R.styleable.MainItemText);
        initAttrs();
        setOnClickListener(this);
    }

    private void initAttrs(){
        int n = typedArray.getIndexCount();
        int attr;
        for (int i = 0 ; i < n ; i++){
            attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.MainItemText_left_ic:
                    leftIcon = typedArray.getDrawable(attr);
                    break;
                case R.styleable.MainItemText_my_text:
                    mText = typedArray.getString(attr);
                    break;
            }
        }
        typedArray.recycle();
        if (leftIcon!=null){
            mLeftImageBtn.setImageDrawable(leftIcon);
        }else {
            mLeftImageBtn.setVisibility(GONE);
        }
        mTvText.setText(mText);
    }


    @Override
    public void onClick(View v) {

    }
}
