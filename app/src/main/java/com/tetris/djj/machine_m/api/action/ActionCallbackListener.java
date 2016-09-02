package com.tetris.djj.machine_m.api.action;

/**
 * Created by Adu on 2015/10/19.
 */
public interface ActionCallbackListener {
    /**
     * 成功时调用
     *
     * @param datas 返回的数据
     */
    void onSuccess(int isSuc, String des, String datas);

    /**
     * 失败时调用
     *
     * @param errorEvent 错误码
     * @param message    错误信息
     */
    void onFailure(String errorEvent, String message);

    void onBefore();

    void onFinish();
}
