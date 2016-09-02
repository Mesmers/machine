package com.tetris.djj.machine_m.utils;


import com.tetris.djj.machine_m.BaseApplication;

/**
 * Created by Adu on 2015/10/21.
 */
public class ResUtils {

    /**
     * 获取字符串资源
     * @param resourceId
     * @return
     */
    public static String getString(int resourceId){
        return BaseApplication.getInstance().getResources().getString(resourceId);
    }

    public static int getColor(int colorId){
        return BaseApplication.getInstance().getResources().getColor(colorId);
    }
}
