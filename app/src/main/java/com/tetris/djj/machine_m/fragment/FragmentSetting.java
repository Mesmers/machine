package com.tetris.djj.machine_m.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.BaseFragment;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.api.action.AppActionImpl;
import com.tetris.djj.machine_m.utils.ActivityManager;
import com.tetris.djj.machine_m.widget.MainItemText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/6/30.
 */
public class FragmentSetting extends BaseFragment implements View.OnClickListener{

//    @Bind(R.id.widget_main_setting_security)//安全设置
//    MainItemText mitSecurity;
//    @Bind(R.id.widget_main_setting_about_us)//关于我们
//    MainItemText mitAboutUs;
//    @Bind(R.id.widget_main_setting_feed_back)//意见反馈
//    MainItemText mitFeedBack;

    public FragmentSetting(){
        super();
    }

    public FragmentSetting(BaseApplication application, Activity activity, Context context) {
        super(application,activity,context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main_setting,null);
        mApplication = BaseApplication.getInstance();
        mActivity = getActivity();
        mContext = getContext();
        appAction = new AppActionImpl(mContext);
        ButterKnife.bind(this,mView);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {

    }

    @OnClick({R.id.btn_main_setting_logout})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_main_setting_logout:
                ActivityManager.getInstance().finishActivity(mActivity);
                break;
        }
    }
}
