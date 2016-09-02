package com.tetris.djj.machine_m.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.BaseFragment;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.api.action.AppActionImpl;

/**
 * Created by hehe on 2016/6/30.
 */
public class FragmentHome extends BaseFragment {


    public FragmentHome(){
        super();
    }

    public FragmentHome(BaseApplication application, Activity activity, Context context) {
        super(application,activity,context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main_home,null);
        mApplication = BaseApplication.getInstance();
        mActivity = getActivity();
        mContext = getContext();
        appAction = new AppActionImpl(mContext);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {

    }
}
