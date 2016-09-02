package com.tetris.djj.machine_m.api.action;

import android.view.animation.AccelerateInterpolator;

import java.io.File;
import java.util.List;

/**
 * Created by Adu on 2015/10/19.
 */
public interface AppAction {

    //登录
    void login(String userId, String password, ActionCallbackListener listener);

}
