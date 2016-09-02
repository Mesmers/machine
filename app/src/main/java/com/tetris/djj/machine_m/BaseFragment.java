package com.tetris.djj.machine_m;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tetris.djj.machine_m.api.action.AppAction;

/**
 * Created by Adu on 2015/9/23.
 */
public abstract class BaseFragment extends Fragment {

    protected BaseApplication mApplication;
    protected Activity mActivity;
    protected Context mContext;
    protected View mView;
    protected AppAction appAction;

    public BaseFragment() {
        super();
    }

    public BaseFragment(BaseApplication application, Activity activity, Context context) {
        mApplication = application;
        mActivity = activity;
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initEvents();
        initDatas();
        return mView;
    }

    protected abstract void initEvents();

    protected abstract void initDatas();
}
