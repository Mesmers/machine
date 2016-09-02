package com.tetris.djj.machine_m.api.action;

/**
 * Created by Adu on 2015/10/19.
 */
public class ErrorEvent {
    static final public String PARAM_NULL = "PARAM_NULL"; // 参数为空
    static final public String PARAM_ILLEGAL = "PARAM_ILLEGAL"; // 参数不合法
    static final public String NET_ERROR = "NET_ERROR"; // 网络请求失败
    static final public String DATA_ERROR = "DATA_ERROR"; //数据解析错误
    static final public String IS_SUC_ERROR = "IS_SUC_ERROR";//isSuc错误
}
