package com.tetris.djj.machine_m;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.tetris.djj.machine_m.api.action.AppAction;
import com.tetris.djj.machine_m.api.http.HttpEngine;
import com.tetris.djj.machine_m.utils.ActivityManager;
import com.tetris.djj.machine_m.utils.SystemBarTintManager;

/**
 * Created by hehe on 2016/6/29.
 */
public abstract class BaseActivity extends FragmentActivity {

    protected BaseApplication mApplication;
    protected Context mContext;
    protected ProgressDialog pd;
    protected int color = R.color.login_stop_color;
    protected AppAction appAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        else {
            View decirView = getWindow().getDecorView();
            int options = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decirView.setSystemUiVisibility(options);
        }
        ActivityManager.getInstance().addActivity(this);
        mApplication = BaseApplication.getInstance();
        appAction = mApplication.getAppAction();
        mContext = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(color);//通知栏所需颜色
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    //事件绑定
    protected abstract void initEvents();

    //获取并初始化UI数据
    protected abstract void initDatas();

    public BaseActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        HttpEngine.getInstance().cancel();
    }

    protected void showProgressDialog() {
        showProgressDialog("");
    }

    protected void showProgressDialog(String text) {
        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setMessage("加载中…");
        pd.show();
    }

    protected void dismissProgressDialog() {
        if (pd != null) {
            pd.dismiss();
        }
    }
}
