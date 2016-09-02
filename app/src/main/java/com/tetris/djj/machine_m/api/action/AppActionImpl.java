package com.tetris.djj.machine_m.api.action;

import android.content.Context;
import android.text.TextUtils;


import com.android.volley.toolbox.StringRequest;
import com.tetris.djj.machine_m.api.Api;
import com.tetris.djj.machine_m.api.http.ApiRequest;
import com.tetris.djj.machine_m.api.http.HttpEngine;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Adu on 2015/10/19.
 */
public class AppActionImpl implements AppAction {

    private Context context;
    private boolean isCanceled = false;

    public AppActionImpl(Context context) {
        this.context = context;
    }

    public void cancel() {
        HttpEngine.getInstance().cancel();
    }

    //登录
    @Override
    public void login(String userId, String password, final ActionCallbackListener listener) {

        // 参数检查
        if (TextUtils.isEmpty(userId)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "用户名为空");
            }
            return;
        }

        if (TextUtils.isEmpty(password)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "密码为空");
            }
            return;
        }

        //构造参数
        Map<String, String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("password", password);
        StringRequest request = ApiRequest.getRequest(Api.LOGIN, params, listener);
        if (listener != null) {
            listener.onBefore();
        }
        HttpEngine.getInstance().addRequest(request);
    }

}
