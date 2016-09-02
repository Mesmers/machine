package com.tetris.djj.machine_m.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.BaseFragment;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.api.action.AppActionImpl;
import com.tetris.djj.machine_m.widget.MainItemText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/6/30.
 */
public class FragmentUser extends BaseFragment implements View.OnClickListener{

//    @Bind(R.id.i_btn_main_user_bell)
//    ImageButton mImgBtnBell;
//    @Bind(R.id.i_btn_main_user_user)
//    ImageButton mImgBtnUser;
//    @Bind(R.id.widget_main_user_authority)//我的权限
//    MainItemText mitAuthority;
//    @Bind(R.id.widget_main_user_record)//浏览记录
//    MainItemText mitRecord;
//    @Bind(R.id.widget_main_user_news)//新闻
//    MainItemText mitNews;

    public FragmentUser(){
        super();
    }

    public FragmentUser(BaseApplication application, Activity activity, Context context) {
        super(application,activity,context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main_user,null);
        mApplication = BaseApplication.getInstance();
        mActivity = getActivity();
        mContext = getContext();
        appAction = new AppActionImpl(mContext);
        ButterKnife.bind(this, mView);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {

    }

    @OnClick({R.id.i_btn_main_user_bell,R.id.i_btn_main_user_user})
    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.i_btn_main_user_bell:

               break;
           case R.id.i_btn_main_user_user:

               break;
       }
    }
}
