package com.tetris.djj.machine_m;

import android.app.Application;

import com.tetris.djj.machine_m.api.action.AppAction;
import com.tetris.djj.machine_m.api.action.AppActionImpl;
import com.tetris.djj.machine_m.utils.LogUtils;
import com.tetris.djj.machine_m.utils.PreferencesUtils;

/**
 * Created by hehe on 2016/6/29.
 */
public class BaseApplication extends Application {

    private final String TAG="BaseApplication";

    //用户信息
    public static String token;
    public static String userId;
    public static String password;
    private static BaseApplication mInstance = null;
    private AppAction appAction;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        appAction = new AppActionImpl(this);
        token = PreferencesUtils.getString("token","");
        userId = PreferencesUtils.getString("userId","");
        password = PreferencesUtils.getString("password","");
    }

    public static BaseApplication getInstance(){
        return mInstance;
    }

    public AppAction getAppAction() {
        return appAction;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtils.e(TAG, "onLowMemory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        LogUtils.e(TAG, "onTerminate");
    }
}
