package com.tetris.djj.machine_m.api.http;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.tetris.djj.machine_m.BaseApplication;

/**
 * Created by Adu on 2015/10/19.
 */
public class HttpEngine {

    private final static String TAG = "HttpEngine";
    private final static String ENCODE_TYPE = "UTF-8";
    private final static int TIME_OUT = 15000;

    private static HttpEngine instance = null;
    private RequestQueue mQueue;

    private HttpEngine() {
        mQueue = Volley.newRequestQueue(BaseApplication.getInstance());
    }

    public static HttpEngine getInstance() {
        if (instance == null) {
            instance = new HttpEngine();
        }
        return instance;
    }

    public void addRequest(Request request){
        mQueue.add(request);
        mQueue.start();
    }

    public void cancel(){
        mQueue.stop();
    }
}
