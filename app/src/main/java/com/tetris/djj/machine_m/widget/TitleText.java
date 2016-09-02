package com.tetris.djj.machine_m.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.utils.ActivityManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/7/2.
 */
public class TitleText extends RelativeLayout implements View.OnClickListener{

    @Bind(R.id.tv_widget_title_text)
    TextView mTvTitleText;
    @Bind(R.id.i_btn_title_go_home)
    ImageButton mImgBtnTitleGoHome;

    private View mView;
    private TypedArray typedArray;
    private Context mContext;

    private boolean mShowLeftIcon;
    private String mTitleText;
    private String target="";
    private String[] mClasses;

    public TitleText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.widget_viewgroup_title,this,true);
        ButterKnife.bind(this,mView);
        mContext = context;
        typedArray = mContext.obtainStyledAttributes(attrs,R.styleable.TitleText);
        initAttrs();
        setOnClickListener(this);
    }

    public void setTitle(String text){
        mTvTitleText.setText(text);
    }

    private void initAttrs(){
        int n = typedArray.getIndexCount();
        int attrs;
        for (int i =0;i<n;i++){
            attrs = typedArray.getIndex(i);
            switch (attrs){
                case R.styleable.TitleText_title_text:
                    mTitleText = typedArray.getString(attrs);
                    break;
                case R.styleable.TitleText_show_left_icon:
                    mShowLeftIcon = typedArray.getBoolean(attrs,true);
                    break;
                case R.styleable.TitleText_title_target:
                    target = typedArray.getString(attrs);
                    break;
            }
        }
        typedArray.recycle();
        mTvTitleText.setText(mTitleText);
        if (!mShowLeftIcon)
            mImgBtnTitleGoHome.setVisibility(GONE);
        mClasses = target.split(",");
        for (int i = 0 ; i < mClasses.length ; i++)
            mClasses[i] = "com.tetris.djj.machine_m.activity.main.home."+mClasses[i];
    }



    @OnClick({R.id.i_btn_title_go_home,R.id.i_btn_title_back})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.i_btn_title_go_home:
                for (int i = 0 ; i < mClasses.length ;i++)
                    try {
                        ActivityManager.getInstance().finishActivity(Class.forName(mClasses[i]));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                ActivityManager.getInstance().finishActivity(mContext.getClass());
                break;
            case R.id.i_btn_title_back:
                ActivityManager.getInstance().finishActivity(mContext.getClass());
                break;
        }
    }
}
