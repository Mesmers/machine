package com.tetris.djj.machine_m.api.http;

import android.text.TextUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.api.action.ActionCallbackListener;
import com.tetris.djj.machine_m.api.action.ErrorEvent;
import com.tetris.djj.machine_m.config.NetConfig;
import com.tetris.djj.machine_m.utils.JsonUtils;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adu on 2015/10/19.
 */
public class ApiRequest {

    //带参数
    public static StringRequest getRequest(String url, final Map<String, String> params, final ActionCallbackListener listener) {
        StringRequest request = new StringRequest(NetConfig.HTTP_MOTHOD, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (listener != null) {
                    if (response != null) {
                        int isSuc;
                        String des;
                        String datas;
                        //解析json数据
                        JSONObject object;
                        object = JsonUtils.getJSONObject(response);
                        if (object == null) {
                            listener.onFailure(ErrorEvent.DATA_ERROR, "数据解析错误");
                            listener.onFinish();
                            return;
                        }
                        isSuc = JsonUtils.getInt(object, "isSuc");
                        des = JsonUtils.getString(object, "des");
                        datas = JsonUtils.getString(object, "datas");
                        if (des == null || datas == null) {
                            listener.onFailure(ErrorEvent.DATA_ERROR, "数据解析错误");
                            listener.onFinish();
                            return;
                        }
                        listener.onSuccess(isSuc, des, datas);
                    }
                    listener.onFinish();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailure(ErrorEvent.NET_ERROR, error.getMessage());
                listener.onFinish();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                //添加header
                Map<String, String> headers = new HashMap<>();
                if (TextUtils.isEmpty(BaseApplication.token) || TextUtils.isEmpty(BaseApplication.userId)) {

                } else {
                    headers.put("ShopId", BaseApplication.userId);
                    headers.put("ShopUserToken", BaseApplication.token);
                    return headers;
                }
                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //添加params
                if (TextUtils.isEmpty(BaseApplication.token) || TextUtils.isEmpty(BaseApplication.userId)) {
                    return params;
                } else {
                    params.put("ShopId", BaseApplication.userId);
                    return params;
                }
            }
        };
        return request;
    }

    //不带参数
    public static StringRequest getRequest(String url, final ActionCallbackListener listener) {
        Map<String, String> params = new HashMap<>();
        return getRequest(url, params, listener);
    }

    //带文件请求
    public static MultipartRequest getMultiRequest(String url, final Map<String, String> params, Map<String, File> fileParams, final ActionCallbackListener listener) {

        final MultipartRequest request = new MultipartRequest(url, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailure(ErrorEvent.NET_ERROR, error.getMessage());
                listener.onFinish();
            }
        }, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (listener != null) {
                    if (response != null) {
                        int isSuc;
                        String des;
                        String datas;
                        //解析json数据
                        JSONObject object;
                        object = JsonUtils.getJSONObject(response);
                        if (object == null) {
                            listener.onFailure(ErrorEvent.DATA_ERROR, "数据解析错误");
                            listener.onFinish();
                            return;
                        }
                        isSuc = JsonUtils.getInt(object, "isSuc");
                        des = JsonUtils.getString(object, "des");
                        datas = JsonUtils.getString(object, "datas");
                        if (des == null || datas == null) {
                            listener.onFailure(ErrorEvent.DATA_ERROR, "数据解析错误");
                            listener.onFinish();
                            return;
                        }
                        listener.onSuccess(isSuc, des, datas);
                    }
                    listener.onFinish();
                }
            }
        }, fileParams, params) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                //添加header
                Map<String, String> headers = new HashMap<>();
                if (TextUtils.isEmpty(BaseApplication.token) || TextUtils.isEmpty(BaseApplication.userId)) {

                } else {
                    headers.put("ShopId", BaseApplication.userId);
                    headers.put("ShopUserToken", BaseApplication.token);
                    return headers;
                }
                return super.getHeaders();
            }
            //MultiRequest重写getParams()不会调用， 需要在参数里添加
        };
        return request;
    }
}
